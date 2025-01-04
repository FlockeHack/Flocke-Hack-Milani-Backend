package flockehackemilani.com.br.flockehackemilani.service;

import flockehackemilani.com.br.flockehackemilani.entity.AgcAccreditationEntity;
import flockehackemilani.com.br.flockehackemilani.entity.CreditDivergenceEntity;
import flockehackemilani.com.br.flockehackemilani.entity.FileEntity;
import flockehackemilani.com.br.flockehackemilani.entity.CreditQualificationEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import flockehackemilani.com.br.flockehackemilani.enumeration.TypeEnum;
import flockehackemilani.com.br.flockehackemilani.mapper.FormMapper;
import flockehackemilani.com.br.flockehackemilani.mapper.ResponseMapper;
import flockehackemilani.com.br.flockehackemilani.model.request.AgcAccreditationRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.CreditDivergenceRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.CreditQualificationRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.AgcAccreditationResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.CreditDivergenceResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.CreditQualificationResponse;
import flockehackemilani.com.br.flockehackemilani.repository.AgcAccreditationRepository;
import flockehackemilani.com.br.flockehackemilani.repository.CreditDivergenceRepository;
import flockehackemilani.com.br.flockehackemilani.repository.CreditQualificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FormService {

  private final ProtocolService protocolService;
  private final CreditQualificationRepository creditQualificationRepository;
  private final AgcAccreditationRepository agcAccreditationRepository;
  private final CreditDivergenceRepository creditDivergenceRepository;
  private final FileService fileService;

  public CreditQualificationResponse createCreditQualificationForm(final MultipartFile petition,
                                                                   final MultipartFile powerOfAttorney,
                                                                   final List<MultipartFile> attachments,
                                                                   final CreditQualificationRequest request) {
    log.info("[FORM_SERVICE] - Creating Credit Qualification Form");
    final String email = request.getCreditorEmail();
    final String protocolNumber = protocolService.buildProtocolNumber(SegmentEnum.CREDIT_QUALIFICATION, email);
    final CreditQualificationEntity creditQualificationEntity = FormMapper.mapFromRequestToCreditQualificationEntity(protocolNumber, request);

    final FileEntity petitionFileEntity = fileService.createFile(SegmentEnum.CREDIT_QUALIFICATION, TypeEnum.PETITION, protocolNumber, petition);
    final FileEntity powerOfAttorneyEntity = fileService.createFile(SegmentEnum.CREDIT_QUALIFICATION, TypeEnum.POWER_OF_ATTORNEY, protocolNumber, powerOfAttorney);

    final CreditQualificationEntity savedCreditQualification = creditQualificationRepository.save(creditQualificationEntity);
    fileService.saveFile(petitionFileEntity);
    fileService.saveFile(powerOfAttorneyEntity);
    attachments.forEach(attachment ->  fileService.createFile(SegmentEnum.CREDIT_QUALIFICATION, TypeEnum.ATTACHMENT, protocolNumber, attachment));

    log.info("[FORM_SERVICE] - Created Credit Qualification Form: {}", savedCreditQualification.getProtocolNumber());
    return ResponseMapper.mapToCreditQualificationResponse(savedCreditQualification);
  }

  public AgcAccreditationResponse createAgcAccreditationForm(AgcAccreditationRequest agcAccreditationRequest) {
    log.info("Creating agc accreditation form...");
    final String email = agcAccreditationRequest.getRepresentativeEmail();
    final String protocolNumber = protocolService.buildProtocolNumber(SegmentEnum.AGC_ACCREDITATION, email);
    final AgcAccreditationEntity entity = FormMapper.mapToAgcAccreditationEntity(protocolNumber, agcAccreditationRequest);

    final AgcAccreditationEntity savedAgcAccreditationEntity = agcAccreditationRepository.save(entity);

    log.info("Created Agc accreditation form: {}", savedAgcAccreditationEntity.getProtocolNumber());
    return ResponseMapper.mapToAgcAccreditationResponse(savedAgcAccreditationEntity);
  }

  public CreditDivergenceResponse createCreditDivergence(MultipartFile petition,
                                                        MultipartFile powerOfAttorney,
                                                        List<MultipartFile> attachments,
                                                        CreditDivergenceRequest request) {
    log.info("[FORM_SERVICE] - Creating Credit Divergence Form");
    final String email = request.getCreditorEmail();
    final String protocolNumber = protocolService.buildProtocolNumber(SegmentEnum.CREDIT_DIVERGENCE, email);

    final CreditDivergenceEntity creditDivergenceEntity = FormMapper.mapToCreditDivergenceEntity(protocolNumber, request);
    final FileEntity petitionFileEntity = fileService.createFile(SegmentEnum.CREDIT_DIVERGENCE, TypeEnum.PETITION, protocolNumber, petition);
    final FileEntity powerOfAttorneyFileEntity = fileService.createFile(SegmentEnum.CREDIT_DIVERGENCE, TypeEnum.POWER_OF_ATTORNEY, protocolNumber, powerOfAttorney);

    final CreditDivergenceEntity creditDivergenceSavedEntity = creditDivergenceRepository.save(creditDivergenceEntity);
    fileService.saveFile(petitionFileEntity);
    fileService.saveFile(powerOfAttorneyFileEntity);
    attachments.forEach(attachment -> fileService.createFile(SegmentEnum.CREDIT_DIVERGENCE, TypeEnum.ATTACHMENT, protocolNumber, attachment));

    log.info("[FORM-SERVICE] - Created Credit Divergence Form: {}", creditDivergenceSavedEntity.getProtocolNumber());
    return ResponseMapper.mapToCreditDivergenceResponse(creditDivergenceSavedEntity);
  }

}
