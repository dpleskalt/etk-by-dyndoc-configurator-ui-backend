package hr.ericsson.ehealth.belarus.dyndoc.configurator.controller;

import hr.ericsson.ehealth.belarus.clc.logger.util.ClcLogger;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.ClassModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.service.ObjectClassService;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.specification.ObjectClassSpec;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/classes")
public class ObjectClassController {

  private final ObjectClassService objectClassService;
  private final ClcLogger log;

  /**
   * @param objectClassId
   * @return Object class with the supplied class id.
   */
  @GetMapping("/{objectClassId}")
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
    log.logMessage(" ---> Get object class with id: " + objectClassId, LogLevel.DEBUG);
    return ResponseEntity.ok(objectClassService.getById(objectClassId));
  }

  /**
   * Retrieves all object classes.
   *
   * @return All object classes.
   */
  @GetMapping
  @ApiOperation(
      value = "View all object classes",
      notes = "Returns all object classes",
      response = List.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved all data"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal error")
      })
  public ResponseEntity<Page<ClassModel>> findObjectClasses(
      ObjectClassSpec objectClassSpec, Pageable pageable) {
    log.logMessage(" ---> Find object classes", LogLevel.DEBUG);
    return ResponseEntity.ok(objectClassService.getAll(objectClassSpec, pageable));
  }

  /**
   * Creates a new object class.
   *
   * @return Created object class object.
   */
  @PostMapping
  @ApiOperation(
      value = "Create a new class object",
      notes = "Returns created class object",
      response = ClassModel.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully created a new class object"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal error")
      })
  public ResponseEntity<ClassModel> createObjectClass(@Valid @RequestBody ClassModel classModel) {
    log.logMessage("  ---> Create object class: {}" + classModel, LogLevel.DEBUG);
    return ResponseEntity.ok(objectClassService.createObjectClass(classModel));
  }

  /**
   * Update an object class information.
   *
   * @return Updated object class.
   */
  @PutMapping("/{objectClassId}")
  @ApiOperation(
      value = "Update an object class information",
      notes = "Returns updated object class",
      response = ClassModel.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully updated object class information"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal error")
      })
  public ResponseEntity<ClassModel> updateObjectClass(
      @PathVariable(value = "objectClassId") Integer objectClassId,
      @RequestBody ClassModel classModel) {
    log.logMessage("  ---> Update object class: {}" + classModel, LogLevel.DEBUG);
    return ResponseEntity.ok(objectClassService.updateObjectClass(objectClassId, classModel));
  }

  /** Deletes specific object class with the supplied object class id. */
  @DeleteMapping("/{objectClassId}")
  @ApiOperation(
      value =
          "Deletes specific object class with the supplied object class id with the designation",
      notes = "Returns void")
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message = "Successfully deletes the specific object class with the designation"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal error")
      })
  @ResponseStatus(HttpStatus.OK)
  public void deleteObjectClass(
      @ApiParam(value = "Object class id", required = true) @PathVariable("objectClassId")
          Integer objectClassId) {
    log.logMessage(" ---> Delete object class with id: {}" + objectClassId, LogLevel.DEBUG);
    objectClassService.remove(objectClassId);
  }
}
