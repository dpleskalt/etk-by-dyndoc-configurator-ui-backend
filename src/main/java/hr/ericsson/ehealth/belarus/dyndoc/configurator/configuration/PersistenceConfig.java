package hr.ericsson.ehealth.belarus.dyndoc.configurator.configuration;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.audit.UsernameAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
public class PersistenceConfig {

  @Bean
  AuditorAware<String> auditorProvider() {
    return new UsernameAuditorAware();
  }
}
