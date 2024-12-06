package fact.it.recensieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LidResponse {
    private String id;
    private String voornaam;
    private String achternaam;
    private String email;
}
