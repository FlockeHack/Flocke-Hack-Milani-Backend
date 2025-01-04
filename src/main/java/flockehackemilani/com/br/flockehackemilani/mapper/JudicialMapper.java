package flockehackemilani.com.br.flockehackemilani.mapper;

import flockehackemilani.com.br.flockehackemilani.entity.JudicialBankruptcyEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialEventEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialRecoveryEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialSettlementEntity;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialBankruptcyRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialRecoveryRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialSettlementRequest;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class JudicialMapper {

  public JudicialRecoveryEntity mapToJudicialRecoveryEntity(final JudicialRecoveryRequest request, final String protocolNumber) {
    return JudicialRecoveryEntity.builder()
            .protocolNumber(protocolNumber)
            .name(request.getName())
            .location(request.getLocation())
            .relatedCompanies(request.getRelatedCompanies())
            .cnpj(request.getCnpj())
            .processNumber(request.getProcessNumber())
            .county(request.getCounty())
            .court(request.getCourt())
            .judge(request.getJudge())
            .judicialAdministrator(request.getJudicialAdministrator())
            .updateDate(LocalDate.now())
            .orderDate(request.getOrderDate())
            .assemblyProtocolNumber(request.getAssemblyProtocolNumber())
            .status(request.getStatus())
            .build();
  }

  public JudicialBankruptcyEntity mapToJudicialBankruptcyEntity(final JudicialBankruptcyRequest request, final String protocolNumber) {
    return JudicialBankruptcyEntity.builder()
            .protocolNumber(protocolNumber)
            .name(request.getName())
            .location(request.getLocation())
            .relatedCompanies(request.getRelatedCompanies())
            .cnpj(request.getCnpj())
            .processNumber(request.getProcessNumber())
            .county(request.getCounty())
            .court(request.getCourt())
            .judge(request.getJudge())
            .judicialAdministrator(request.getJudicialAdministrator())
            .updateDate(LocalDate.now())
            .orderDate(request.getOrderDate())
            .closedDate(request.getOrderDate())
            .assemblyProtocolNumber(request.getAssemblyProtocolNumber())
            .status(request.getStatus())
            .build();
  }

  public JudicialSettlementEntity mapToJudicialSettlementEntity(final JudicialSettlementRequest request, final String protocolNumber) {
    return JudicialSettlementEntity.builder()
            .name(request.getName())
            .relatedCompanies(request.getRelatedCompanies())
            .protocolNumber(protocolNumber)
            .cnpj(request.getCnpj())
            .processNumber(request.getProcessNumber())
            .county(request.getCounty())
            .court(request.getCourt())
            .judge(request.getJudge())
            .judicialAdministrator(request.getJudicialAdministrator())
            .updateDate(LocalDate.now())
            .orderDate(request.getOrderDate())
            .status(request.getStatus())
            .build();
  }

  public JudicialEventEntity mapToJudicialEventEntity(final JudicialEventRequest request, final String fileId) {
    return JudicialEventEntity.builder()
            .protocolNumber(request.getProtocolNumber())
            .titleName(request.getTitleName())
            .date(request.getEventDate())
            .fileId(fileId)
            .build();
  }

}
