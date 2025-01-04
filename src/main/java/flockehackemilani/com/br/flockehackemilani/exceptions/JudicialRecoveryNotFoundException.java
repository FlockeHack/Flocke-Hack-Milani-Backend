package flockehackemilani.com.br.flockehackemilani.exceptions;

public class JudicialRecoveryNotFoundException extends RuntimeException {

  public JudicialRecoveryNotFoundException(String message) {
    super(message);
  }

  public JudicialRecoveryNotFoundException(String message, Throwable error) {
    super(message, error);
  }
}
