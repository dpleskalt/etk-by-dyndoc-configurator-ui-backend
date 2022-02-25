package hr.ericsson.ehealth.belarus.dyndoc.configurator.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** Custom rest error response. */
@Data
@Builder
public class ByErrorResponse {

  /** Time stamp. */
  private LocalDateTime timestamp;
  /** Custom status. */
  private String status;
  /** Exception message. */
  private String error;
  /** Custom internationalized message. */
  private List<ByErrorMessage> message;
  /** Request uri. */
  private String path;
  /** Field name */
  private String field;
}
