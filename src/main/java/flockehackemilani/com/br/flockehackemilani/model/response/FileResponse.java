package flockehackemilani.com.br.flockehackemilani.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileResponse {

    private String id;
    private String fileName;
    private String fileDescription;
    private String contentType;

}
