![](https://img.shields.io/badge/spring%20boot%202-compatible-green.svg)

# eHealth Microservice

### Requirements

- Latest openJDK 11

> https://developers.redhat.com/products/openjdk/download

- SonarLint

> https://www.sonarlint.org/

### Eclipse Setup

# Git Hooks
In order for the git hooks to be called by STS (Eclipse) when running under Windows you have to do:
1. Install Cygwin
2. Add the Cygwin bin folder (e.g. cygwin64\bin) to the Windows PATH environmental variable.

# Lombok
Go to `C:\Users\<myusername>\.m2\repository\org\projectlombok\lombok\<version>`, e.g. `C:\Users\<myusername>\.m2\repository\org\projectlombok\lombok\1.18.16` and run lombok-1.18.16.jar with double click to install the plugin. After installing the plugin, we need to restart the IDE.

> https://www.baeldung.com/lombok-ide

### Nexus


Set up JAVA_HOME environment variable:

> https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html

To import certificates go to [certs folder](certs) and execute in Command Promt as administrator:

```
keytool -importcert -file EGADRootCA.cer -alias ci_cd  -storepass changeit -keystore "%JAVA_HOME%\lib\security\cacerts"

keytool -importcert -file EGADIssuingCA3.cer -alias ci_cd1 -storepass changeit -keystore "%JAVA_HOME%\lib\security\cacerts"
```

To check out certificates execute:

```
keytool -list -keystore "%JAVA_HOME%\lib\security\cacerts" -alias ci_cd -storepass changeit

keytool -list -keystore "%JAVA_HOME%\lib\security\cacerts" -alias ci_cd1 -storepass changeit
```

In .mvn folder create local-settings.xml:

```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
      <localRepository/>
      <interactiveMode/>
      <offline/>
      <pluginGroups/>
	  <servers>
		<server>
			<id>maven-public</id>
			<username>nexus_username</username>
		    <password>nexus_password</password>
		</server>
	  </servers>
      <mirrors/>
      <proxies/>
	  <profiles/>
    <activeProfiles/>
</settings>
```

Execute `mvn clean install`.

### Usage

Run as Spring Boot App:

1. configuration-server
2. dyndoc-configurator-ui-backend service

Go to:

> http://localhost:8080/dyndoc-configurator-ui-backend/api

> http://localhost:8080/dyndoc-configurator-ui-backend/swagger-ui/

> http://localhost:8080/dyndoc-configurator-ui-backend/actuator/health

> http://localhost:8080/dyndoc-configurator-ui-backend/actuator/info

> POST http://localhost:8080/dyndoc-configurator-ui-backend/actuator/refresh

Service configuration url example:

```
http://localhost:8888/<spring.application.name>/<profile>
```

Go to:

> http://localhost:8888/dyndoc-configurator-ui-backend/default

### Test

Execute:

```
mvn clean test
```

If everything went okay, go to:

> dyndoc-configurator-ui-backend\target\site\jacoco-ut\index.html


### Set Up Git

```
git remote add origin <url>
```

During the project initialization below git hooks have been created:
- [commit-msg](.git/hooks/commit-msg)
- [per-commit](.git/hooks/pre-commit)
- [pre-push](.git/hooks/pre-push)

