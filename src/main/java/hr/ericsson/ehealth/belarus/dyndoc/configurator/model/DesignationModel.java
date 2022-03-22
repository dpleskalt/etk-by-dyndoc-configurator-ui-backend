package hr.ericsson.ehealth.belarus.dyndoc.configurator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesignationModel {

  @ApiModelProperty(value = "Id of designation.")
  private Integer id;

  @ApiModelProperty(value = "Id of object class.")
  private Integer objectClassId;

  @ApiModelProperty(value = "Human language of the designation", example = "en")
  private String language;

  @ApiModelProperty(value = "The text value for this designation")
  private String value;

  @ApiModelProperty(value = "Designation status. Possible values (D, N), default value = 'D'")
  private String status;

  @ApiModelProperty(value = "Designation note.")
  String note;

  @ApiModelProperty(value = "Date the designation was created.")
  Date creationDate;

  @ApiModelProperty(value = "User who created the designation.")
  String createdBy;

  @ApiModelProperty(value = "Last date the designation was updated.")
  Date updateDate;

  @ApiModelProperty(value = "User who last updated the designation.")
  String updatedBy;
}
