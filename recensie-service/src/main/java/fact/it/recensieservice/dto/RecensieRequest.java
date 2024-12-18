package fact.it.recensieservice.dto;

import java.time.LocalDateTime;

public class RecensieRequest {
    private String titelRecensie;
    private String description;
    private LocalDateTime datumTijd;
    private String boekId; // Use just the ID
    private String lidId;  // Use just the ID

    // Constructor
    public RecensieRequest(String titelRecensie, String description, LocalDateTime datumTijd, String boekId, String lidId) {
        this.titelRecensie = titelRecensie;
        this.description = description;
        this.datumTijd = datumTijd;
        this.boekId = boekId;
        this.lidId = lidId;
    }

    // Default Constructor
    public RecensieRequest() {}

    // Getters and Setters
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

