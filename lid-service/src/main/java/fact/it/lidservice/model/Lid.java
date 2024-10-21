package fact.it.lidservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "lid")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Lid {
    private String id;
    private String voornaam;
    private String achternaam;
    private String email;
}