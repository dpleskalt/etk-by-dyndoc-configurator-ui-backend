package hr.ericsson.ehealth.belarus.dyndoc.configurator.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model example with lombok.Data and lombok.Builder annotations. See <a
 * href="https://projectlombok.org/features">lombok features</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DyndocModel {

  /** Field to show data in the view. */
  @Size(min = 3, max = 20, message = "ERR_BY_2004")
  private String data;

  /** Field to show data in the view. */
  @NotNull(message = "ERR_BY_1000")
  private String name;
}
