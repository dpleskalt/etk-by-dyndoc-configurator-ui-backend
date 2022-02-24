package hr.ericsson.ehealth.belarus.dyndoc.configurator.model;

import lombok.Builder;
import lombok.Data;

/** Custom error message */
@Data
@Builder
public class ByErrorMessage {
  private String language;
  private String value;
}
