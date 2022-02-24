package hr.ericsson.ehealth.belarus.dyndoc.configurator.service.impl;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.dao.DyndocRepository;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.dao.dto.DyndocDto;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.DyndocModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.service.DyndocService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service with the dependency injection enabled by the lombok.AllArgsConstructor annotation. See <a
 * href="https://projectlombok.org/features/constructor">lombok constructor</a>
 */
@AllArgsConstructor
@Service
public class DyndocServiceImpl implements DyndocService {

  private final DyndocRepository repository;

  /**
   * Method to process data.
   *
   * @return Instance of {@link hr.ericsson.ehealth.belarus.dyndoc.configurator.model.DyndocModel
   *     TestModel}
   */
  public DyndocModel processData() {
    DyndocDto fetchData = this.repository.fetchData();
    String dataValue = fetchData.getData() + " processed.";
    return DyndocModel.builder().data(dataValue).build();
  }
}
