package flockehackemilani.com.br.flockehackemilani.exceptions;

public class JudicialSettlementNotFoundException extends RuntimeException {

  public JudicialSettlementNotFoundException(String message) {
    super(message);
  }

  public JudicialSettlementNotFoundException(String message, Throwable error) {
    super(message, error);
  }

}
