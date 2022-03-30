package hr.ericsson.ehealth.belarus.dyndoc.configurator.audit;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/** This class is used as database trigger to set the current user on the audit columns. */
@Slf4j
public class UsernameAuditorAware implements AuditorAware<String> {

  /** This user is used in case, for example, some internal scheduler is running. */
  private static final String SYSTEM_USER = "SYSTEM";

  @Override
  public Optional<String> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    log.debug("Current authentication: " + authentication);

    if (authentication == null || !authentication.isAuthenticated()) {
      return Optional.of(SYSTEM_USER);
    }
    return Optional.of(((User) authentication.getPrincipal()).getUsername());
  }
}
