package flockehackemilani.com.br.flockehackemilani.mapper;

import flockehackemilani.com.br.flockehackemilani.entity.ContactEntity;
import flockehackemilani.com.br.flockehackemilani.model.request.ContactRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContactMapper {

  public ContactEntity mapToContactEntity(final ContactRequest request) {
    return ContactEntity.builder()
            .name(request.getName())
            .email(request.getEmail())
            .phone(request.getPhone())
            .city(request.getCity())
            .uf(request.getUf())
            .message(request.getMessage())
            .build();
  }

}
