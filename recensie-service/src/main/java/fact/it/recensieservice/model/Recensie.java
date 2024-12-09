package fact.it.recensieservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recensies")
public class Recensie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titelRecensie;
    private String description;
    private LocalDateTime datumTijd;
    private Long lidId;
    private Long boekId;

    // No-argument constructor
    public Recensie() {
    }

    // All-arguments constructor
    public Recensie(long id, String titelRecensie, String description, LocalDateTime datumTijd, Long lidId, Long boekId) {
        this.id = id;
        this.titelRecensie = titelRecensie;
        this.description = description;
        this.datumTijd = datumTijd;
        this.lidId = lidId;
        this.boekId = boekId;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitelRecensie() {
        return titelRecensie;
    }

    public void setTitelRecensie(String titelRecensie) {
        this.titelRecensie = titelRecensie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDatumTijd() {
        return datumTijd;
    }

    public void setDatumTijd(LocalDateTime datumTijd) {
        this.datumTijd = datumTijd;
    }

    public Long getLidId() {
        return lidId;
    }

    public void setLidId(Long lidId) {
        this.lidId = lidId;
    }

    public Long getBoekId() {
        return boekId;
    }

    public void setBoekId(Long boekId) {
        this.boekId = boekId;
    }
}
