package hr.ericsson.ehealth.belarus.dyndoc.configurator.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DesignationModel {
  @ApiModelProperty(value = "Human language of the designation", example = "en")
  private String language;

  @ApiModelProperty(value = "The text value for this designation")
  private String value;
}
