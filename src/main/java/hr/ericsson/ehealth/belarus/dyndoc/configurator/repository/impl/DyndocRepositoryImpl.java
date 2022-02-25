package hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.impl;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.dto.DyndocDto;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.repository.DyndocRepository;
import org.springframework.stereotype.Repository;

/** Repository example. */
@Repository
public class DyndocRepositoryImpl implements DyndocRepository {

  /**
   * Method to fetch data.
   *
   * @return Instance of {@link DyndocDto TestDto}
   */
  public DyndocDto fetchData() {
    return DyndocDto.builder().data("Fetched data").build();
  }
}
