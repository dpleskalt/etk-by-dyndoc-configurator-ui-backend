package hr.ericsson.ehealth.belarus.dyndoc.configurator.controller;

import hr.ericsson.ehealth.belarus.clc.logger.util.ClcLogger;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.ByErrorResponse;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.model.CommonErrorCode;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.service.ByException;
import hr.ericsson.ehealth.belarus.dyndoc.configurator.service.ByExceptionService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class WebRestControllerAdvice {

  private final ByExceptionService exceptionService;
  private final ClcLogger clcLogger;

  /**
   * Handles general exceptions.
   *
   * @param ex
   * @param httpRequest
   * @return
   */
  @ExceptionHandler(Throwable.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ByErrorResponse customException(final Throwable ex, final HttpServletRequest httpRequest) {
    return ByErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(CommonErrorCode.UNEXPECTED_ERROR.errorCode)
        .error(ex.getMessage())
        .message(
            exceptionService.createErrorMessages(CommonErrorCode.UNEXPECTED_ERROR.errorCode, null))
        .path(httpRequest != null ? httpRequest.getRequestURI() : null)
        .build();
  }

  /**
   * Handles validations exceptions.
   *
   * @param ex
   * @param httpRequest
   * @return
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public List<ByErrorResponse> validationException(
      final MethodArgumentNotValidException ex, final HttpServletRequest httpRequest) {
    clcLogger.logError(ex);

    List<ByErrorResponse> result = new ArrayList<>();

    // it should never happen
    if (ex.getBindingResult() == null
        || CollectionUtils.isEmpty(ex.getBindingResult().getFieldErrors())) {
      result.add(
          ByErrorResponse.builder()
              .timestamp(LocalDateTime.now())
              .status(CommonErrorCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION_EMPTY.errorCode)
              .error(ex.getMessage())
              .message(
                  exceptionService.createErrorMessages(
                      CommonErrorCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION_EMPTY.errorCode, null))
              .path(httpRequest != null ? httpRequest.getRequestURI() : null)
              .build());

      return result;
    }

    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
      List<Object> args = exceptionService.extractArgs(fieldError);
      String errorCode = fieldError.getDefaultMessage();

      ByErrorResponse errorResponse =
          ByErrorResponse.builder()
              .timestamp(LocalDateTime.now())
              .status(errorCode)
              .error(ex.getMessage())
              .message(exceptionService.createErrorMessages(errorCode, args))
              .path(httpRequest != null ? httpRequest.getRequestURI() : null)
              .field(fieldError.getField())
              .build();

      result.add(errorResponse);
    }
    return result;
  }

  /**
   * Handles Checked exceptions.
   *
   * @param ex
   * @param httpRequest
   * @return
   */
  @ExceptionHandler(ByException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ByErrorResponse checkedException(
      final ByException ex, final HttpServletRequest httpRequest) {
    return ByErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(
            ex.getErrorCode() != null
                ? ex.getErrorCode()
                : CommonErrorCode.UNEXPECTED_ERROR.errorCode)
        .error(ex.getMessage())
        .message(
            exceptionService.createErrorMessages(
                ex.getErrorCode() != null
                    ? ex.getErrorCode()
                    : CommonErrorCode.UNEXPECTED_ERROR.errorCode,
                null))
        .path(httpRequest != null ? httpRequest.getRequestURI() : null)
        .build();
  }

  /**
   * Handles Unchecked exceptions.
   *
   * @param ex
   * @param httpRequest
   * @return
   */
  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ByErrorResponse uncheckedException(
      final RuntimeException ex, final HttpServletRequest httpRequest) {
    String errorCode = CommonErrorCode.UNEXPECTED_ERROR.errorCode;
    List<Object> args = new ArrayList<>();

    // TODO mapped runtime exception to error code and args
    if (ex instanceof IndexOutOfBoundsException) {
      errorCode = CommonErrorCode.INDEX_OUT_OF_BOUNDS_EXCEPTION.errorCode;
    }

    return ByErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(errorCode)
        .error(ex.getMessage())
        .message(exceptionService.createErrorMessages(errorCode, args))
        .path(httpRequest != null ? httpRequest.getRequestURI() : null)
        .build();
  }
}
