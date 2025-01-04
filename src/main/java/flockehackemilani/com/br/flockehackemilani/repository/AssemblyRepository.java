package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.AssemblyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssemblyRepository extends MongoRepository<AssemblyEntity, String> {

  Optional<AssemblyEntity> findByProtocolNumber(String protocolNumber);

}
