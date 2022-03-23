package hr.ericsson.ehealth.belarus.dyndoc.configurator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {ManagementWebSecurityAutoConfiguration.class})
@ComponentScan("hr.ericsson.ehealth.belarus")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
