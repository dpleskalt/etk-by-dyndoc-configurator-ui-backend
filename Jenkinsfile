pipeline {

   agent any
   tools {
       maven 'Maven 3.6.3'
       jdk 'OpenJDK-11'
       nodejs 'nodeJS-14.15.1'
   }
   options {
      buildDiscarder(logRotator(numToKeepStr: '5'))
      skipStagesAfterUnstable()
      disableConcurrentBuilds()
   }
   environment {
      BRANCH_STAGE = fetchBranchStage()
   }

   stages {
     stage('Preparation') {
        when {
           expression { env.BRANCH_STAGE != 'feature' }
        }
        steps { preparation() }
     }
      stage('Build') {
        when {
           expression { env.BRANCH_STAGE != 'feature' }
        }
        steps { builds() }
      }
      stage('Unit tests') {
        when {
           expression { env.BRANCH_STAGE != 'feature' }
        }
        steps { unitTest() }
        post {
          always {
            jacoco changeBuildStatus: true, minimumInstructionCoverage: '70', runAlways: true
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/TEST-*.xml'
          }
        }
      }
      stage('Code coverage') {
        when {
           expression { env.BRANCH_STAGE != 'feature' }
        }
        steps { codeCoverage() }
      }
      stage('Sanity check') {
        when {
           expression { env.BRANCH_STAGE != 'feature' }
        }
        steps { sanityCheck() }
      }
      stage('Install') {
        when {
           expression { env.BRANCH_STAGE != 'feature'}
        }
        steps { install() }
      }
      stage('Integration tests') {
        when {
           expression { env.BRANCH_STAGE != 'feature'}
        }
        steps { integrationTest() }
      }
      stage('Documentation') {
        when {
           expression { env.BRANCH_STAGE == 'master'}
        }
        steps { documentation() }
      }
      stage('Develop Release') {
        when {
           expression { env.BRANCH_STAGE == 'develop'}
        }
        steps { developRelease() }
      }
      stage('Master Release') {
        when {
           expression { env.BRANCH_STAGE == 'master'}
        }
        steps { masterRelease() }
      }
   }
}

def preparation() {
  // this step is used for preparation of build
  echo "Creating changelog"
  def changelogName = 'CHANGELOG-' + env.BUILD_NUMBER + '.md'
  def changelog = sh script: 'git log --pretty="- %s"', returnStdout: true
  sh 'git log --pretty="- %s" > ' + changelogName

  archiveArtifacts artifacts: changelogName, followSymlinks: false, onlyIfSuccessful: true
}

def builds() {
  // this step is used for building app
	echo "Building project"
	sh 'mvn --batch-mode clean compile'
}

def unitTest() {
  // this step is used to execute unit tests
	echo "Executing unit tests"
  sh 'mvn --batch-mode resources:testResources compiler:testCompile test'
}

def codeCoverage() {
  // this step is used to execute code coverage scripts
  // this step stays empty for maven project because code coverage will execute using maven plugin jacoco-maven-plugin
	echo "Generating code coverage report"
}

def sanityCheck() {
  // this step is used for analysis of source code
	echo "TODO SonarCube check"
}

def install() {
  // this step makes install of packed app (for maven it install in local repo)
	echo "Install"

  // *** uncomment this section if need to join angular with spring boot in one app (change url of frontend repo)
  // *** needs also to extend pom.xml to add extra parameter where to find frontent binary files
  //dir ('front') {
  //  git branch: 'develop', credentialsId: '3ca3a95a-9d22-4db0-8db7-2bcf0a290d8f', url: 'https://git.devops.cc.lab.etk.extern.eu.ericsson.se/ETK_CC/poc-client-ui.git'
  //}
  //dir ('front') {
  //  sh 'npm install'
  //}
  //dir ('front') {
  //  sh 'ng build'
  //}

  sh 'mvn --batch-mode package -DskipTests'
}

def integrationTest() {
  // this step is used to execute integration tests
	echo "Executing integration tests"
	sh 'mvn --batch-mode failsafe:integration-test failsafe:verify'
}

def documentation() {
  // this step is used to build documentation (for java app it is javadoc)
	echo "Documentation builder"
  sh 'mvn --batch-mode site'
}

def developRelease() {
  // this step is used to mark relese version and deploy on nexus
	echo "Develop Release"

  def pom_artifactId = fetchPomData('artifactId')
  def pom_groupId = fetchPomData('groupId')
  def pom_version = fetchPomData('version')
  def pom_finalName = fetchPomData('build.finalName')

  nexusPublisher nexusInstanceId: 'nexus_repository_devops', nexusRepositoryId: 'maven-by-develop',
    packages: [
      [$class: 'MavenPackage',
      mavenAssetList: [
        [classifier: '',
        extension: '',
        filePath: 'target/' + pom_finalName + '.jar']
      ],
      mavenCoordinate: [
        artifactId: pom_artifactId,
        groupId: pom_groupId,
        packaging: 'jar',
        version: pom_version+'+'+env.BUILD_NUMBER]
      ]
    ]
}

def masterRelease() {
  // this step is used to mark relese version and deploy on nexux
	echo "Master Release"

  def pom_artifactId = fetchPomData('artifactId')
  def pom_groupId = fetchPomData('groupId')
  def pom_version = fetchPomData('version')
  def pom_finalName = fetchPomData('build.finalName')

  nexusPublisher nexusInstanceId: 'nexus_repository_devops', nexusRepositoryId: 'maven-by',
    packages: [
      [$class: 'MavenPackage',
      mavenAssetList: [
        [classifier: '',
        extension: '',
        filePath: 'target/' + pom_finalName + '.jar']
      ],
      mavenCoordinate: [
        artifactId: pom_artifactId,
        groupId: pom_groupId,
        packaging: 'jar',
        version: pom_version]
      ]
    ]
}


def fetchPomData(expression) {
  def result = sh script: 'mvn help:evaluate -Dexpression=project.' + expression + ' -q -DforceStdout', returnStdout: true
  return result
}
def fetchBranchStage() {
  def release_regex = 'release/[0-9]+\\.[0-9]+\\.[0-9]+'

  if( env.BRANCH_NAME == 'master' ) {
        return 'master'
  } else if ( env.BRANCH_NAME == 'develop' ) {
		return 'develop'
	} else if ( env.CHANGE_TARGET == 'master' ) {
		return 'pull_for_master'
	} else if ( env.CHANGE_TARGET == 'develop' ) {
		return 'pull_for_develop'
	} else {
    def matcher = env.BRANCH_NAME =~ release_regex
    if (matcher.find()) {
      return "release"
    } else {
		  return 'feature'
    }
	}
}
