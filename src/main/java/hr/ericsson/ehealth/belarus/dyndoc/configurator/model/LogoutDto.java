package hr.ericsson.ehealth.belarus.dyndoc.configurator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogoutDto {
  private String logoutUrl;
  private String authCookieName;
}
