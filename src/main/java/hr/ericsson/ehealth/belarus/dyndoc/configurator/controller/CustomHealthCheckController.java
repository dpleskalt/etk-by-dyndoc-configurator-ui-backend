package hr.ericsson.ehealth.belarus.dyndoc.configurator.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controller with custom health check endpoints */
@AllArgsConstructor
@RestController
public class CustomHealthCheckController {

  private ApplicationEventPublisher eventPublisher;

  /** set readiness status to OUT_OF_SERVICE load balancer will stop sending requests */
  @GetMapping("/readiness/refuse")
  public String readinessRefuse() {
    AvailabilityChangeEvent.publish(eventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
    return "Readiness marked as REFUSING_TRAFFIC";
  }

  /** set readiness status to UP in case of cancellation purpose */
  @GetMapping("/readiness/accept")
  public String readinessAccept() {
    AvailabilityChangeEvent.publish(eventPublisher, this, ReadinessState.ACCEPTING_TRAFFIC);
    return "Readiness marked as ACCEPTING_TRAFFIC";
  }
}
