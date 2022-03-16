package hr.ericsson.ehealth.belarus.dyndoc.configurator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
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
public class CategoryModel {
  @ApiModelProperty(value = "Category id")
  Integer objectCategoryId;

  @ApiModelProperty(value = "Category code")
  String objectCategoryCode;

  @ApiModelProperty(value = "Category name")
  String objectCategoryName;

  @ApiModelProperty(value = "Additional representations for the concept")
  List<DesignationModel> designation;

  @ApiModelProperty(value = "Category note")
  String note;

  @ApiModelProperty(value = "Category type code")
  private String compositionTypeCode;

  @ApiModelProperty(value = "Category type system")
  private String compositionTypeSystem;

  @ApiModelProperty(value = "Category is parent")
  private String isParent;

  @ApiModelProperty(value = "Observation parent code")
  private String parentCode;

  @ApiModelProperty(value = "Category system")
  private String objectCategorySystem;

  private String categoryTypeCode;
  private String permissionCode;
}
