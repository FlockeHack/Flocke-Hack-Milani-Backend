package flockehackemilani.com.br.flockehackemilani.mapper;

import flockehackemilani.com.br.flockehackemilani.entity.AgcAccreditationEntity;
import flockehackemilani.com.br.flockehackemilani.entity.CreditDivergenceEntity;
import flockehackemilani.com.br.flockehackemilani.entity.CreditQualificationEntity;
import flockehackemilani.com.br.flockehackemilani.model.request.AgcAccreditationRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.CreditDivergenceRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.CreditQualificationRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FormMapper {

  public CreditQualificationEntity mapFromRequestToCreditQualificationEntity(final String protocolNumber, final CreditQualificationRequest request) {
    return CreditQualificationEntity.builder()
            .protocolNumber(protocolNumber)
            .creditorName(request.getCreditorName())
            .creditorEmail(request.getCreditorEmail())
            .cpf(request.getCpf())
            .cnpj(request.getCnpj())
            .creditValue(request.getCreditValue())
            .responsibleAttorney(request.getResponsibleAttorney())
            .debtor(request.getDebtor())
            .debtorClass(request.getDebtorClass())
            .message(request.getMessage())
            .build();
  }

  public AgcAccreditationEntity mapToAgcAccreditationEntity(final String protocolNumber, final AgcAccreditationRequest request) {
    return AgcAccreditationEntity.builder()
            .protocolNumber(protocolNumber)
            .assemblyProtocolNumber(request.getAssemblyProtocolNumber())
            .assembly(request.getAssembly())
            .creditorName(request.getCreditorName())
            .cpf(request.getCpf())
            .cnpj(request.getCnpj())
            .creditValue(request.getCreditValue())
            .creditorClass(request.getCreditorClass())
            .representativeName(request.getRepresentativeName())
            .representativePhone(request.getRepresentativePhone())
            .representativeEmail(request.getRepresentativeEmail())
            .build();
  }

  public CreditDivergenceEntity mapToCreditDivergenceEntity(final String protocolNumber, final CreditDivergenceRequest request) {
    return CreditDivergenceEntity.builder()
            .protocolNumber(protocolNumber)
            .creditorName(request.getCreditorName())
            .creditorEmail(request.getCreditorEmail())
            .creditorPhone(request.getCreditorPhone())
            .cpf(request.getCpf())
            .cnpj(request.getCnpj())
            .creditValue(request.getCreditValue())
            .responsibleAttorney(request.getResponsibleAttorney())
            .debtor(request.getDebtor())
            .debtorClass(request.getDebtorClass())
            .message(request.getMessage())
            .build();
  }
}
