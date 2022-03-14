package hr.ericsson.ehealth.belarus.dyndoc.configurator.service;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.DyndocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(
    properties = {
      "spring.cloud.config.enabled: false",
      "logging.level.hr.ericsson.ehealth.belarus.dyndoc.configurator: OFF"
    })
class DyndocServiceUnitTest {

  @Autowired private DyndocService service;

  @MockBean DyndocRepository repository;

  //  @Test
  //  void fetchAndProcessDataTest() {
  //    Mockito.when(repository.fetchData())
  //        .thenReturn(DyndocDto.builder().data("Mockito data").build());
  //    Assert.assertEquals("Mockito data processed.", this.service.processData().getData());
  //  }
}
