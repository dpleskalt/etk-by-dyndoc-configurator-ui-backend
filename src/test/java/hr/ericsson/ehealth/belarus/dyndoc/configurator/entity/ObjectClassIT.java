package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import static org.junit.jupiter.api.Assertions.*;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.AbstractIntegrationTest;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.ObjectClassRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ObjectClassIT extends AbstractIntegrationTest {

  @Autowired ObjectClassRepository objectClassRepository;

  @Test
  void createObjectClassTest() {
    ObjectClass objectClass = new ObjectClass();
    objectClass.setObjectClassCode("10");
    objectClass.setObjectClassName("Test");
    objectClass.setStatus("D");
    objectClass.setInputForm("M");
    objectClass.setValidFrom(LocalDate.now());

    ObjectClass saved = objectClassRepository.save(objectClass);

    assertEquals(saved.getCreatedBy(), "Dmitry");
    assertEquals(saved.getCreationDate(), LocalDate.now());
  }
}
