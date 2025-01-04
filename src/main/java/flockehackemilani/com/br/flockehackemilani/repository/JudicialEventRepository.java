package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.JudicialEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JudicialEventRepository extends MongoRepository<JudicialEventEntity, String> {

  List<JudicialEventEntity> findAllByProtocolNumber(String protocolNumber);

}
