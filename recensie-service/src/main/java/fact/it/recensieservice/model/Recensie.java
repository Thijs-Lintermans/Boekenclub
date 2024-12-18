package fact.it.recensieservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recensies")
public class Recensie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titelRecensie;
    private String description;
    private LocalDateTime datumTijd;

    private String boekId; // Moved this above lidId
    private String lidId;  // Moved this below boekId

    // No-argument constructor
    public Recensie() {
    }

    // All-arguments constructor
    public Recensie(String titelRecensie, String description, LocalDateTime datumTijd, String boekId, String lidId) {
        this.titelRecensie = titelRecensie;
        this.description = description;
        this.datumTijd = datumTijd;
        this.boekId = boekId;
        this.lidId = lidId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getBoekId() {
        return boekId;
    }

    public void setBoekId(String boekId) {
        this.boekId = boekId;
    }

    public String getLidId() {
        return lidId;
    }

    public void setLidId(String lidId) {
        this.lidId = lidId;
    }
}
