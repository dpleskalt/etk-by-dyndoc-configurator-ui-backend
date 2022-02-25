package hr.ericsson.ehealth.belarus.dyndoc.configurator.repository;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.dto.DyndocDto;

public interface DyndocRepository {
  public DyndocDto fetchData();
}
