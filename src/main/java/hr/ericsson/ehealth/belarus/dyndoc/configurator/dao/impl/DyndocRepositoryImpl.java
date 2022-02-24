package hr.ericsson.ehealth.belarus.dyndoc.configurator.dao.impl;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.dao.DyndocRepository;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.dao.dto.DyndocDto;
import org.springframework.stereotype.Repository;

/** Repository example. */
@Repository
public class DyndocRepositoryImpl implements DyndocRepository {

  /**
   * Method to fetch data.
   *
   * @return Instance of {@link hr.ericsson.ehealth.belarus.dyndoc.configurator.dao.dto.DyndocDto
   *     TestDto}
   */
  public DyndocDto fetchData() {
    return DyndocDto.builder().data("Fetched data").build();
  }
}
