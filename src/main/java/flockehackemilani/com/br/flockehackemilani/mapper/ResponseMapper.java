package flockehackemilani.com.br.flockehackemilani.mapper;

import flockehackemilani.com.br.flockehackemilani.entity.AgcAccreditationEntity;
import flockehackemilani.com.br.flockehackemilani.entity.AssemblyEntity;
import flockehackemilani.com.br.flockehackemilani.entity.AssemblyEventEntity;
import flockehackemilani.com.br.flockehackemilani.entity.ContactEntity;
import flockehackemilani.com.br.flockehackemilani.entity.CreditDivergenceEntity;
import flockehackemilani.com.br.flockehackemilani.entity.CreditQualificationEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialBankruptcyEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialEventEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialRecoveryEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialSettlementEntity;
import flockehackemilani.com.br.flockehackemilani.model.response.AgcAccreditationResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.AssemblyEventResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.AssemblyResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.ContactResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.CreditDivergenceResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.CreditQualificationResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialBankruptcyResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialEventResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialRecoveryResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialSettlementResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseMapper {

  public CreditQualificationResponse mapToCreditQualificationResponse(final CreditQualificationEntity entity) {
    return CreditQualificationResponse.builder()
            .id(entity.getId())
            .protocolNumber(entity.getProtocolNumber())
            .creditorName(entity.getCreditorName())
            .creditorEmail(entity.getCreditorEmail())
            .cpf(entity.getCpf())
            .cnpj(entity.getCnpj())
            .creditValue(entity.getCreditValue())
            .responsibleAttorney(entity.getResponsibleAttorney())
            .debtor(entity.getDebtor())
            .debtorClass(entity.getDebtorClass())
            .message(entity.getMessage())
            .build();
  }

  public AgcAccreditationResponse mapToAgcAccreditationResponse(final AgcAccreditationEntity entity) {
    return AgcAccreditationResponse.builder()
            .id(entity.getId())
            .protocolNumber(entity.getProtocolNumber())
            .assembly(entity.getAssembly())
            .creditorName(entity.getCreditorName())
            .cpf(entity.getCpf())
            .cnpj(entity.getCnpj())
            .creditValue(entity.getCreditValue())
            .creditorClass(entity.getCreditorClass())
            .representativeName(entity.getRepresentativeName())
            .representativePhone(entity.getRepresentativePhone())
            .representativeEmail(entity.getRepresentativeEmail())
            .build();
  }

  public CreditDivergenceResponse mapToCreditDivergenceResponse(final CreditDivergenceEntity entity) {
    return CreditDivergenceResponse.builder()
            .id(entity.getId())
            .protocolNumber(entity.getProtocolNumber())
            .creditorName(entity.getCreditorName())
            .creditorEmail(entity.getCreditorEmail())
            .creditorPhone(entity.getCreditorPhone())
            .build();
  }

  public JudicialRecoveryResponse mapToJudicialRecoveryResponse(final JudicialRecoveryEntity entity) {
    return JudicialRecoveryResponse.builder()
            .id(entity.getId())
            .name(entity.getName())
            .location(entity.getLocation())
            .protocolNumber(entity.getProtocolNumber())
            .relatedCompanies(entity.getRelatedCompanies())
            .cnpj(entity.getCnpj())
            .processNumber(entity.getProcessNumber())
            .county(entity.getCounty())
            .court(entity.getCourt())
            .judge(entity.getJudge())
            .judicialAdministrator(entity.getJudicialAdministrator())
            .updateDate(entity.getUpdateDate())
            .orderDate(entity.getOrderDate())
            .closedDate(entity.getClosedDate())
            .assemblyProtocolNumber(entity.getAssemblyProtocolNumber())
            .status(entity.getStatus().getStatus())
            .build();
  }

  public JudicialBankruptcyResponse mapToJudicialBankruptcyResponse(final JudicialBankruptcyEntity entity) {
    return JudicialBankruptcyResponse.builder()
            .id(entity.getId())
            .name(entity.getName())
            .protocolNumber(entity.getProtocolNumber())
            .relatedCompanies(entity.getRelatedCompanies())
            .cnpj(entity.getCnpj())
            .processNumber(entity.getProcessNumber())
            .county(entity.getCounty())
            .court(entity.getCourt())
            .judge(entity.getJudge())
            .judicialAdministrator(entity.getJudicialAdministrator())
            .updateDate(entity.getUpdateDate())
            .orderDate(entity.getOrderDate())
            .assemblyId(entity.getAssemblyProtocolNumber())
            .status(entity.getStatus().status)
            .build();
  }

  public JudicialSettlementResponse mapToJudicialSettlementResponse(final JudicialSettlementEntity entity) {
    return JudicialSettlementResponse.builder()
            .id(entity.getId())
            .protocolNumber(entity.getProtocolNumber())
            .name(entity.getName())
            .relatedCompanies(entity.getRelatedCompanies())
            .cnpj(entity.getCnpj())
            .processNumber(entity.getProcessNumber())
            .county(entity.getCounty())
            .court(entity.getCourt())
            .judge(entity.getJudge())
            .judicialAdministrator(entity.getJudicialAdministrator())
            .updateDate(entity.getUpdateDate())
            .orderDate(entity.getOrderDate())
            .status(entity.getStatus().status)
            .build();
  }

  public JudicialEventResponse mapToJudicialEventResponse(final JudicialEventEntity entity) {
    return JudicialEventResponse.builder()
            .id(entity.getId())
            .titleName(entity.getTitleName())
            .protocolNumber(entity.getProtocolNumber())
            .date(entity.getDate())
            .fileId(entity.getFileId())
            .build();
  }

  public AssemblyResponse mapToAssemblyResponse(final AssemblyEntity entity) {
    return AssemblyResponse.builder()
            .id(entity.getId())
            .protocolNumber(entity.getProtocolNumber())
            .name(entity.getName())
            .processNumber(entity.getProcessNumber())
            .email(entity.getEmail())
            .build();
  }

  public AssemblyEventResponse mapToAssemblyEventResponse(final AssemblyEventEntity entity) {
    return AssemblyEventResponse.builder()
            .id(entity.getId())
            .protocolNumber(entity.getProtocolNumber())
            .eventName(entity.getEventName())
            .eventDate(entity.getEventDate())
            .observation(entity.getObservation())
            .event(entity.getEvent())
            .eventType(entity.getEventType().name())
            .build();
  }

  public ContactResponse mapToContactResponse(final ContactEntity entity) {
    return ContactResponse.builder()
            .id(entity.getId())
            .name(entity.getName())
            .email(entity.getEmail())
            .phone(entity.getPhone())
            .city(entity.getCity())
            .uf(entity.getUf())
            .message(entity.getMessage())
            .build();
  }

}
