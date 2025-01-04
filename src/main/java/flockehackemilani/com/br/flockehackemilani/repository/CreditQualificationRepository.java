package flockehackemilani.com.br.flockehackemilani.repository;

import flockehackemilani.com.br.flockehackemilani.entity.CreditQualificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditQualificationRepository extends MongoRepository<CreditQualificationEntity, String> {
}
