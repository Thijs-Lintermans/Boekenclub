package fact.it.recensieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RecensieResponse {
    private Long id;
    private String titelRecensie;
    private String description;
    private LocalDateTime datumTijd;
    private BoekResponse boek; // Embed BoekResponse
    private LidResponse lid;   // Embed LidResponse
}
