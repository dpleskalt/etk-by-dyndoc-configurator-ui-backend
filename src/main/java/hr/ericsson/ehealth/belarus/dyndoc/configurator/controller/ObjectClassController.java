package hr.ericsson.ehealth.belarus.dyndoc.configurator.controller;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.ClassModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.service.ObjectClassService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ObjectClassController {

  private final ObjectClassService objectClassService;

  /**
   * @param objectClassId
   * @return Object class with the supplied class id.
   */
  @GetMapping("/object-class/{objectClassId}")
  @ApiOperation(
      value = "Retrieve specific object class with the supplied id",
      notes = "Returns object class with the supplied id",
      response = ClassModel.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved object class"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal error")
      })
  public ResponseEntity<ClassModel> getObjectClass(
      @ApiParam(value = "Object class id.", required = true) @PathVariable("objectClassId")
          Integer objectClassId) {

    return ResponseEntity.ok(objectClassService.getById(objectClassId));
  }
}
