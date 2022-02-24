package hr.ericsson.ehealth.belarus.dyndoc.configurator.configuration;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "by.errors")
public class ByErrorConfig {

  private List<String> languages;
}
