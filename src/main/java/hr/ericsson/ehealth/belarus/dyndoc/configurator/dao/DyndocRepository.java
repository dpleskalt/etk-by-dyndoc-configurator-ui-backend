package hr.ericsson.ehealth.belarus.dyndoc.configurator.dao;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.dao.dto.DyndocDto;

public interface DyndocRepository {
  public DyndocDto fetchData();
}
