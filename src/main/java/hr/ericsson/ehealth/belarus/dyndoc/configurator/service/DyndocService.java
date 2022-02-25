package hr.ericsson.ehealth.belarus.dyndoc.configurator.service;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.dto.DyndocDto;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.DyndocModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.DyndocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service with the dependency injection enabled by the lombok.AllArgsConstructor annotation. See <a
 * href="https://projectlombok.org/features/constructor">lombok constructor</a>
 */
@AllArgsConstructor
@Service
public class DyndocService {

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
