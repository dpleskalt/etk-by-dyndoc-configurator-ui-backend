package hr.ericsson.ehealth.belarus.dyndoc.configurator.entity;

import lombok.Getter;

public enum ObjectStatus {
  D("D"),
  N("N");

  @Getter private final String value;

  ObjectStatus(String value) {
    this.value = value;
  }
}
