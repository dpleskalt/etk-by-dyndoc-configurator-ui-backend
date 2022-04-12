package hr.ericsson.ehealth.belarus.dyndoc.configurator.controller;

import hr.ericsson.ehealth.belarus.clc.logger.annotation.ClcLog;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.LogoutDto;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.service.UserSessionService;
import hr.ericsson.ehealth.belarus.orgslct.dto.DepartmentDto;
import hr.ericsson.ehealth.belarus.orgslct.dto.OrganizationDto;
import hr.ericsson.ehealth.belarus.orgslct.dto.UserDto;
import hr.ericsson.ehealth.belarus.orgslct.service.UserService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final UserSessionService userSessionService;

  @ClcLog(logLevel = LogLevel.DEBUG)
  @ApiOperation(value = "Find current user.")
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/current")
  public ResponseEntity<UserDto> findCurrentUser() {
    return ResponseEntity.ok(userService.findCurrent());
  }

  @ClcLog(logLevel = LogLevel.DEBUG)
  @ApiOperation(value = "Find organizations.")
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/organizations")
  public ResponseEntity<List<OrganizationDto>> findOrganizations() {
    return ResponseEntity.ok(userService.findOrganizations());
  }

  @ClcLog(logLevel = LogLevel.DEBUG)
  @ApiOperation(value = "Find departments within organization.")
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/departments-within-organization")
  public ResponseEntity<List<DepartmentDto>> findDepartmentsWithinOrganization(
      @RequestParam String organizationIdentifier) {
    return ResponseEntity.ok(userService.findDepartmentsWithinOrganization(organizationIdentifier));
  }

  @ClcLog(logLevel = LogLevel.DEBUG)
  @ApiOperation(value = "Logout user.")
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/logout")
  public ResponseEntity<LogoutDto> logoutUser() {
    return ResponseEntity.ok(userSessionService.logoutUser());
  }
}
