package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.JudicialRecoveryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudicialRecoveryRepository extends MongoRepository<JudicialRecoveryEntity, String> {

}
