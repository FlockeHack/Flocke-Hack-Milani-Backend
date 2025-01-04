package flockehackemilani.com.br.flockehackemilani.exceptions;

public class JudicialBankruptcyNotFoundException extends RuntimeException {

  public JudicialBankruptcyNotFoundException(String message) {
    super(message);
  }

  public JudicialBankruptcyNotFoundException(String message, Throwable error) {
    super(message, error);
  }

}
