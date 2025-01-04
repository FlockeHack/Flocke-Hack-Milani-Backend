package flockehackemilani.com.br.flockehackemilani.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "sequences")
public class SequenceEntity {

  @Id
  private String id;
  private String sequenceType;
  private int sequenceValue;

}
