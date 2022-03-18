package hr.ericsson.ehealth.belarus.dyndoc.configurator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassModel {
  @ApiModelProperty(value = "Id of object for dynamic content")
  Integer objectClassId;

  @ApiModelProperty(value = "Class code of object for dynamically created content")
  String objectClassCode;

  @ApiModelProperty(value = "Class object name.")
  String objectClassName;

  @ApiModelProperty(value = "Class class note.")
  String note;

  @ApiModelProperty(value = "Class object order sequence.")
  Integer orderSeq;

  @ApiModelProperty(value = "Class object valid from date.")
  Date validFrom;

  @ApiModelProperty(value = "Class object valid to date.")
  Date validTo;

  @ApiModelProperty(value = "Date the class object was created.")
  Date creationDate;

  @ApiModelProperty(value = "User who created the class object.")
  String createdBy;

  @ApiModelProperty(value = "Last date the class object was updated.")
  Date updateDate;

  @ApiModelProperty(value = "User who last updated the class object.")
  String updatedBy;

  @ApiModelProperty(value = "Class object status. Possible values (D, N), default value = 'D'")
  String status;

  @ApiModelProperty(value = "Class name translations")
  List<DesignationModel> designation;

  @ApiModelProperty(value = "List of object categories for dynamically created content")
  List<CategoryModel> categories;

  @ApiModelProperty(
      value = "indicates what our input form for dynamic documents will be",
      example = "F - From, G - Grid, V - Specific grid for observations formed by external systems")
  String inputForm;
}
