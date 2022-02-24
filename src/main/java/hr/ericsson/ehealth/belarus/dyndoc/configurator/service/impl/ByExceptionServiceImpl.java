package hr.ericsson.ehealth.belarus.dyndoc.configurator.service.impl;

import hr.ericsson.ehealth.belarus.clc.logger.util.ClcLogger;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.configuration.ByErrorConfig;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.ByErrorMessage;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.service.ByExceptionService;
import java.util.*;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

/** By Exception service to manage error messages */
@Service
@AllArgsConstructor
public class ByExceptionServiceImpl implements ByExceptionService {

  static final String MISSING_TRANSLATION = "No translation for this error";

  private final ByErrorConfig errorConfig;
  private final MessageSource messageSource;
  private final ClcLogger clcLogger;

  @Override
  public List<ByErrorMessage> createErrorMessages(String errorCode, List<Object> args) {
    List<ByErrorMessage> errorMessages = new ArrayList<>();

    if (errorConfig.getLanguages() == null) return errorMessages;

    for (String language : errorConfig.getLanguages()) {
      try {
        String message =
            messageSource.getMessage(
                errorCode, args != null ? args.toArray() : null, Locale.forLanguageTag(language));
        errorMessages.add(ByErrorMessage.builder().language(language).value(message).build());
      } catch (Exception e) {
        errorMessages.add(
            ByErrorMessage.builder()
                .language(language)
                .value(MISSING_TRANSLATION + ": " + errorCode)
                .build());
        clcLogger.logError(e);
      }
    }
    return errorMessages;
  }

  @Override
  public List<Object> extractArgs(FieldError fieldError) {
    if (fieldError == null
        || fieldError.getArguments() == null
        || fieldError.getArguments().length == 1) return null;

    List<Object> args = Arrays.asList(Arrays.stream(fieldError.getArguments()).skip(1).toArray());
    Collections.reverse(args);
    return args;
  }
}
