package fact.it.recensieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BoekResponse {
    private String id;
    private String titel;
    private String auteur;
    private String genre;
    private Date publicatieDatum;
    private Integer aantalPaginas;
}
