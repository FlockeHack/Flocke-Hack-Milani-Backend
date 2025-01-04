package flockehackemilani.com.br.flockehackemilani.enumeration;

import lombok.Getter;

@Getter
public enum SegmentEnum {

  CREDIT_QUALIFICATION("habilitacao de credito"),
  CREDIT_DIVERGENCE("divergencia de credito"),
  AGC_ACCREDITATION("credencimento de agc"),
  JUDICIAL_RECOVERY("recuperacao judicial"),
  JUDICIAL_BANKRUPTCY("falencia judicial"),
  JUDICIAL_SETTLEMENT("liquidacao judicial"),
  ASSEMBLY("assembleia");

  public final String segment;

  SegmentEnum(final String segment) {
    this.segment = segment;
  }

}
