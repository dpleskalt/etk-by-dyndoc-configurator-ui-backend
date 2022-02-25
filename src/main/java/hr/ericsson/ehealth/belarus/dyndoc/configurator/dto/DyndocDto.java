package hr.ericsson.ehealth.belarus.dyndoc.configurator.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Dto example with lombok.Data and lombok.Builder annotations. See <a
 * href="https://projectlombok.org/features">lombok features</a>
 */
@Data
@Builder
public class DyndocDto {
  /** Field to transfer the data. */
  private String data;
}
