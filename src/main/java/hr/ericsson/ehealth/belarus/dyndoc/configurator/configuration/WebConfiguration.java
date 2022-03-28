package hr.ericsson.ehealth.belarus.dyndoc.configurator.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedHeaders("content-type", "*")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH");
  }
}
