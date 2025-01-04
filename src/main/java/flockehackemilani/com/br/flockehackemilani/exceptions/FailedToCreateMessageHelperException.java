package flockehackemilani.com.br.flockehackemilani.exceptions;

public class FailedToCreateMessageHelperException extends RuntimeException {

  public FailedToCreateMessageHelperException(String message, Throwable error) {
    super(message, error);
  }

}
