package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.JudicialBankruptcyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudicialBankruptcyRepository extends MongoRepository<JudicialBankruptcyEntity, String> {

}
