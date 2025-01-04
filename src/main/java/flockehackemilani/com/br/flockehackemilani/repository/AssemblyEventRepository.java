package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.AssemblyEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssemblyEventRepository extends MongoRepository<AssemblyEventEntity, String> {

  List<AssemblyEventEntity> findAllByProtocolNumber(String protocolNumber);

}
