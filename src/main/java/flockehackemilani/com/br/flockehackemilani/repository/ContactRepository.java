package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.ContactEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends MongoRepository<ContactEntity, String> {

}
