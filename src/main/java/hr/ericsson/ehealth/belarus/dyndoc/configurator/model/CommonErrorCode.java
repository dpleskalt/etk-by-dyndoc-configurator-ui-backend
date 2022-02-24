package hr.ericsson.ehealth.belarus.dyndoc.configurator.model;

public enum CommonErrorCode {
  UNEXPECTED_ERROR("ERR_BY_1000"),
  METHOD_ARGUMENT_NOT_VALID_EXCEPTION_EMPTY("ERR_BY_1008"),
  INDEX_OUT_OF_BOUNDS_EXCEPTION("ERR_BY_1001");

  public final String errorCode;

  CommonErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}
