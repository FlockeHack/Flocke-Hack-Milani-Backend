package flockehackemilani.com.br.flockehackemilani.service;

import flockehackemilani.com.br.flockehackemilani.entity.FileEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import flockehackemilani.com.br.flockehackemilani.enumeration.TypeEnum;
import flockehackemilani.com.br.flockehackemilani.exceptions.FileDataNotCaughtException;
import flockehackemilani.com.br.flockehackemilani.mapper.FileMapper;
import flockehackemilani.com.br.flockehackemilani.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
@AllArgsConstructor
public class FileService {

  private final FileRepository fileRepository;

  public FileEntity createFile(final SegmentEnum segmentEnum, final TypeEnum typeEnum, final String protocolNumber, final MultipartFile file) {
    final byte[] fileData = this.getFileDataInBytes(file);
    final FileEntity fileEntity = FileMapper.mapToFileEntity(segmentEnum, typeEnum, protocolNumber, file.getOriginalFilename(), fileData);

    return this.saveFile(fileEntity);
  }

  public FileEntity saveFile(final FileEntity fileEntity) {
    return fileRepository.save(fileEntity);
  }

  public FileEntity getFileById(final String id) throws FileNotFoundException {
    return fileRepository.findById(id)
            .orElseThrow(() -> new FileNotFoundException("Arquivo não encontrado para o id: %s".formatted(id)));
  }

  public byte[] getFileDataInBytes(MultipartFile file) {
    try {
      return file.getBytes();
    } catch (IOException ex) {
      throw new FileDataNotCaughtException("Não foi possível obter o conteúdo do arquivo: " + file.getOriginalFilename(), ex);
    }
  }

}
