package fact.it.besprekingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BesprekingReSponse {
    private Long id;
    private String titelBespreking;
    private String description;
    private String datum;
    private Long lidId;
    private Long boekId;
}