package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import static org.junit.jupiter.api.Assertions.*;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.AbstractIntegrationTest;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.ObjectClassLRepository;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.ObjectClassRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

class ObjectClassIT extends AbstractIntegrationTest {

  private static final String TEST_USER = "TestUser";
  private static final String TEST_NAME = "Test name";

  @Autowired ObjectClassRepository objectClassRepository;
  @Autowired ObjectClassLRepository objectClassLRepository;

  @Test
  void createObjectClassTest() {
    ObjectClass objectClass = new ObjectClass();
    objectClass.setObjectClassCode("10");
    objectClass.setObjectClassName("Test");
    objectClass.setStatus("D");
    objectClass.setInputForm("M");
    objectClass.setValidFrom(LocalDate.now());

    ObjectClass saved = objectClassRepository.save(objectClass);

    assertEquals(TEST_USER, saved.getCreatedBy());
    assertEquals(LocalDate.now(), saved.getCreationDate());
  }

  @Test
  void updateObjectClassTest() {

    ObjectClass objectClass = objectClassRepository.getById(80);
    objectClass.setObjectClassName(TEST_NAME);

    ObjectClass saved = objectClassRepository.save(objectClass);

    assertEquals(TEST_USER, saved.getUpdatedBy());
    assertEquals(LocalDate.now(), saved.getUpdateDate());
    assertEquals(TEST_NAME, saved.getObjectClassName());
  }

  @Test
  @Transactional
  void updateObjectClassLTest() {

    ObjectClass objectClass = objectClassRepository.getById(80);
    ObjectClassL objectClassL =
        objectClassLRepository.getById(objectClass.getObjectClassL().get(0).getId());
    objectClassL.setLanguageId("de");

    objectClass.getObjectClassL().set(0, objectClassL);
    ObjectClass saved = objectClassRepository.saveAndFlush(objectClass);

    assertEquals(TEST_USER, saved.getObjectClassL().get(0).getUpdatedBy());
    assertEquals("de", saved.getObjectClassL().get(0).getLanguageId());
    assertEquals(LocalDate.now(), saved.getObjectClassL().get(0).getUpdateDate());
  }
}
