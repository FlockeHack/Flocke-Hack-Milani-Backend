package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.AgcAccreditationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgcAccreditationRepository extends MongoRepository<AgcAccreditationEntity, String> {

}
