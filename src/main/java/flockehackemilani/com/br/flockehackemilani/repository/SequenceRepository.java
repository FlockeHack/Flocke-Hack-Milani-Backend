package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.SequenceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SequenceRepository extends MongoRepository<SequenceEntity, String> {

  Optional<SequenceEntity> findBySequenceType(String sequenceType);
}
