package flockehackemilani.com.br.flockehackemilani.controller;

import flockehackemilani.com.br.flockehackemilani.entity.FileEntity;
import flockehackemilani.com.br.flockehackemilani.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/v1/arquivos")
@AllArgsConstructor
public class FileController {

  private final FileService fileService;

  @GetMapping("/download/{id}")
  public ResponseEntity<byte[]> downloadFile(@PathVariable String id) throws FileNotFoundException {
    final FileEntity fileEntity = fileService.getFileById(id);

    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    headers.setContentDispositionFormData("file", fileEntity.getName());

    return ResponseEntity.ok()
            .headers(headers)
            .body(fileEntity.getData());
  }

}
