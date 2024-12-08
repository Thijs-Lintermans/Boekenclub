package fact.it.besprekingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "besprekingen")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bespreking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titelBespreking;
    private String datum;
    private String locatie;
    private String omschrijving;
}
