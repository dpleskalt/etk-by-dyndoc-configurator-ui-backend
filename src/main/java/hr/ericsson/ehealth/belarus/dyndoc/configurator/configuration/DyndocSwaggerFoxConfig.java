package hr.ericsson.ehealth.belarus.dyndoc.configurator.configuration;

import java.util.Collections;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Getter
@Setter
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
public class DyndocSwaggerFoxConfig {

  private String title;
  private String description;
  private String version;
  private String termsOfServiceUrl;
  private String license;
  private String licenseUrl;
  private String contactName;
  private String contactUrl;
  private String contactEmail;

  @Bean
  public Docket apiDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .select()
        .apis(
            RequestHandlerSelectors.basePackage("hr.ericsson.ehealth.belarus.dyndoc.configurator"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
        this.title,
        this.description,
        this.version,
        this.termsOfServiceUrl,
        new Contact(this.contactName, this.contactUrl, this.contactEmail),
        this.license,
        this.licenseUrl,
        Collections.emptyList());
  }
}
