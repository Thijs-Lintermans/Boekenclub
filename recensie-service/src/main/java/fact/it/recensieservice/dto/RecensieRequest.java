package fact.it.recensieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecensieRequest {
    private String titelRecensie;
    private String description;
    private LocalDateTime datumTijd;
    private BoekResponse boek; // Embed BoekResponse
    private LidResponse lid;   // Embed LidResponse
}