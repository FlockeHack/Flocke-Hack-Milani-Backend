package flockehackemilani.com.br.flockehackemilani.handler;

import flockehackemilani.com.br.flockehackemilani.exceptions.MissingInformationRequestException;
import flockehackemilani.com.br.flockehackemilani.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<String> handleResourceNotFoundException(final ResourceNotFoundException exception, final WebRequest request) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MissingInformationRequestException.class)
  public ResponseEntity<String> handleMissingInformationRequestException(final ResourceNotFoundException exception, final WebRequest request) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

}
