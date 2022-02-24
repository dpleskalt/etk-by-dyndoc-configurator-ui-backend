package hr.ericsson.ehealth.belarus.dyndoc.configurator.controller;

import hr.ericsson.ehealth.belarus.clc.logger.util.ClcLogger;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.DyndocModel;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.service.DyndocService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller with the dependency injection enabled by the lombok.AllArgsConstructor annotation.
 * Logging is enabled by lombok.extern.slf4j.Slf4j facade. See <a
 * href="https://projectlombok.org/features/constructor">lombok constructor</a>
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class DyndocController {

  private final DyndocService service;
  private final ClcLogger log;

  /**
   * Method with example of swagger annotations (@ApiResponses, @ApiParam). Creates a new item.
   *
   * @return Created item.
   */
  @PostMapping
  @ApiOperation(
      value = "Create a new item",
      notes = "Returns created item",
      response = DyndocModel.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully created a new item"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal error")
      })
  public DyndocModel createItem(@Valid @RequestBody DyndocModel item) {
    return item; // DyndocModel.builder().data("Created item").build();
  }

  /**
   * Retrieves specific item with the supplied item id.
   *
   * @return Item with the supplied item id.
   */
  @GetMapping("/{id}")
  @ApiOperation(
      value = "Retrieve specific item with the supplied item id",
      notes = "Returns item with the supplied item id",
      response = DyndocModel.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved item"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal error")
      })
  public DyndocModel item(
      @ApiParam(value = "Item id.", required = true) @PathVariable("id") Long id) {
    log.logMessage(" ---> Get item with id: " + id, LogLevel.DEBUG);
    return this.service.processData();
  }

  /**
   * Retrieves all items.
   *
   * @return All items.
   */
  @GetMapping
  @ApiOperation(value = "View all items", notes = "Returns all items", response = Iterable.class)
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
  public Iterable<DyndocModel> items() {
    log.logMessage(" ---> Get all items", LogLevel.DEBUG);
    return Stream.of(DyndocModel.builder().data("Saved data").build())
        .collect(Collectors.toCollection(HashSet::new));
  }

  /**
   * Update an item information.
   *
   * @return Updated item.
   */
  @PutMapping
  @ApiOperation(
      value = "Update an item information",
      notes = "Returns updated item",
      response = DyndocModel.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully updated item information"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal error")
      })
  public DyndocModel updateItem(@RequestBody DyndocModel item) {
    log.logMessage("  ---> Update item: {}" + item, LogLevel.DEBUG);
    return null;
    // return DyndocModel.builder().data("Saved data").build();
  }

  /** Deletes specific item with the supplied item id. */
  @DeleteMapping("/{id}")
  @ApiOperation(value = "Deletes specific item with the supplied item id", notes = "Returns void")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully deletes the specific item"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal error")
      })
  public void delete(@ApiParam(value = "Item id.", required = true) @PathVariable("id") Long id) {
    log.logMessage(" ---> Delete item with id: {}" + id, LogLevel.DEBUG);
  }
}
