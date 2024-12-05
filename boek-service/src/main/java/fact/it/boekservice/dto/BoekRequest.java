package fact.it.boekservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoekRequest {
    private String titel;
    private String auteur;
    private String genre;
    private Date publicatieDatum;
    private Integer aantalPaginas;
}