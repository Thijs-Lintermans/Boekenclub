package fact.it.boekservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(value="boek")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Boek {
    private String id;
    private String titel;
    private String auteur;
    private String genre;
    private LocalDate publicatieDatum;
    private Integer aantalPaginas;
}
