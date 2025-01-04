package flockehackemilani.com.br.flockehackemilani.service;

import flockehackemilani.com.br.flockehackemilani.entity.ProtocolEntity;
import flockehackemilani.com.br.flockehackemilani.entity.SequenceEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import flockehackemilani.com.br.flockehackemilani.exceptions.ProtocolNotFoundException;
import flockehackemilani.com.br.flockehackemilani.mapper.ProtocolMapper;
import flockehackemilani.com.br.flockehackemilani.repository.ProtocolRepository;
import flockehackemilani.com.br.flockehackemilani.repository.SequenceRepository;
import flockehackemilani.com.br.flockehackemilani.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@AllArgsConstructor
public class ProtocolService {

  private final SequenceRepository sequenceRepository;
  private final ProtocolRepository protocolRepository;

  public ProtocolEntity getProtocol(final String protocolNumber) {
    return protocolRepository.findByProtocolNumber(protocolNumber)
            .orElseThrow(() -> new ProtocolNotFoundException("Não foi encontrado um protocolo para o número: %s".formatted(protocolNumber)));
  }

  public String buildProtocolNumber(final SegmentEnum segmentEnum) {
    return this.buildProtocolNumber(segmentEnum, /* email */ null);
  }

  public String buildProtocolNumber(final SegmentEnum segmentEnum, final String email) {
    final String sequence = this.getSequenceAndUpdateIt();

    final LocalDate todayDate = LocalDate.now();
    final String day = String.format("%02d", todayDate.getDayOfMonth());
    final String month = String.format("%02d", todayDate.getMonthValue());
    final String year = String.format("%02d", todayDate.getYear());

    final String protocolNumber = String.format("%s%s%s%s", day, month, year, sequence);
    final ProtocolEntity protocolEntity = ProtocolMapper.mapToProtocolEntity(protocolNumber, segmentEnum, email);
    protocolRepository.save(protocolEntity);

    log.info("[PROTOCOL-SERVICE] - Protocol number created: {} for segment: {}", protocolNumber, segmentEnum.segment);
    return protocolNumber;
  }

  private String getSequenceAndUpdateIt() {
    final SequenceEntity sequenceEntity = sequenceRepository.findBySequenceType(Constants.SEQUENCE_PROTOCOL_STRING)
            .orElseThrow(RuntimeException::new);

    // Increments sequence value and save it, to keep the value atomic
    final int sequence = sequenceEntity.getSequenceValue() + 1;
    sequenceEntity.setSequenceValue(sequence);
    sequenceRepository.save(sequenceEntity);

    return String.format("%07d", sequence);
  }
}
