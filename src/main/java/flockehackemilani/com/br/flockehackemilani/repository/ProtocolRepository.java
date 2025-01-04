package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.ProtocolEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProtocolRepository extends MongoRepository<ProtocolEntity, String> {

  Optional<ProtocolEntity> findByProtocolNumber(String protocolNumber);
}
