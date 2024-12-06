package fact.it.besprekingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BesprekingResponse {
    private Long id;
    private String titelBespreking;
    private String datum;
    private String locatie;
    private String omschrijving;
}
