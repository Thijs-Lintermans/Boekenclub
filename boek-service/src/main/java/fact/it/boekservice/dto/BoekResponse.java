package fact.it.boekservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoekResponse {
    private String id;
    private String titel;
    private String auteur;
    private String genre;
    private LocalDate publicatieDatum;
    private Integer aantalPaginas;
}