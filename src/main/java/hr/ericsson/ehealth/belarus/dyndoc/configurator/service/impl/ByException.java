package hr.ericsson.ehealth.belarus.dyndoc.configurator.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** All checked exception should be mapped to ByException. */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ByException extends Exception {
  private static final long serialVersionUID = -5604932084729913819L;

  private String errorCode;
}
