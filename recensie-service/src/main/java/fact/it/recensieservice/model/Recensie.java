package fact.it.recensieservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.FilterJoinTable;

import java.time.LocalDateTime;

@Entity
@Table(name = "recensies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recensie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titelRecensie;
    private String description;
    private LocalDateTime datumTijd;
    private Long lidId;
    private Long boekId;
}
