package fact.it.besprekingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecensieRequest {
    private String titelRecensie;
    private String description;
    private String datum;
    private Long lidId;
    private Long boekId;
}