package hr.ericsson.ehealth.belarus.dyndoc.configurator.audit;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;

@Slf4j
public class UsernameAuditorAware implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of("Dmitry");
  }

  //    @Override
  //    public Optional<String> getCurrentAuditor() {
  //        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  //
  //        log.debug("Current authentication: " + authentication);
  //
  //        if(authentication == null || !authentication.isAuthenticated()) {
  //            return Optional.empty();
  //        }
  //        return Optional.of(((User)authentication.getPrincipal()).getUsername());
  //    }
}
