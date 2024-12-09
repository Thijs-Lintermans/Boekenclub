package fact.it.besprekingservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "besprekingen")
public class Bespreking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titelBespreking;
    private String datum;
    private String locatie;
    private String omschrijving;

    // Default constructor
    public Bespreking() {
    }

    // All-arguments constructor
    public Bespreking(Long id, String titelBespreking, String datum, String locatie, String omschrijving) {
        this.id = id;
        this.titelBespreking = titelBespreking;
        this.datum = datum;
        this.locatie = locatie;
        this.omschrijving = omschrijving;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitelBespreking() {
        return titelBespreking;
    }

    public void setTitelBespreking(String titelBespreking) {
        this.titelBespreking = titelBespreking;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
}
