package hr.ericsson.ehealth.belarus.dyndoc.configurator.service;

import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.ByErrorMessage;
import java.util.List;
import org.springframework.validation.FieldError;

public interface ByExceptionService {

  /**
   * Creates messages regarding to error code and available languages
   *
   * @param errorCode
   * @param args
   * @return
   */
  List<ByErrorMessage> createErrorMessages(String errorCode, List<Object> args);

  /**
   * extracts validation arguments
   *
   * @param fieldError
   * @return
   */
  List<Object> extractArgs(FieldError fieldError);
}
