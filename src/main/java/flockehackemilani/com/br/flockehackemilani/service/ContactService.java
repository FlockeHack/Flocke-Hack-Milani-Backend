package flockehackemilani.com.br.flockehackemilani.service;

import flockehackemilani.com.br.flockehackemilani.entity.ContactEntity;
import flockehackemilani.com.br.flockehackemilani.mapper.ContactMapper;
import flockehackemilani.com.br.flockehackemilani.mapper.ResponseMapper;
import flockehackemilani.com.br.flockehackemilani.model.request.ContactRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.ContactResponse;
import flockehackemilani.com.br.flockehackemilani.repository.ContactRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ContactService {

  private final ContactRepository contactRepository;

  public ContactResponse createContact(final ContactRequest contactRequest) {
    final ContactEntity contactEntity = ContactMapper.mapToContactEntity(contactRequest);
    final ContactEntity savedContactEntity = contactRepository.save(contactEntity);

    return ResponseMapper.mapToContactResponse(savedContactEntity);

  }

}
