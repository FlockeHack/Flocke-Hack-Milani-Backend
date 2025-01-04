package flockehackemilani.com.br.flockehackemilani.exceptions;

import javassist.NotFoundException;

public class ResourceNotFoundException extends NotFoundException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
