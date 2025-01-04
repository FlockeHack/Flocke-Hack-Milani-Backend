package flockehackemilani.com.br.flockehackemilani.enumeration;

import lombok.Getter;

@Getter
public enum StatusEnum {

  ACTIVE("ATIVO"),
  CLOSED("ENCERRADO");

  public final String status;

  StatusEnum(final String status) {
    this.status = status;
  }
}
