package fact.it.recensieservice.dto;

import java.time.LocalDateTime;

public class RecensieRequest {
    private String titelRecensie;
    private String description;
    private LocalDateTime datumTijd;
    private BoekResponse boek; // Embed BoekResponse
    private LidResponse lid;   // Embed LidResponse

    // Constructor
    public RecensieRequest(String titelRecensie, String description, LocalDateTime datumTijd, BoekResponse boek, LidResponse lid) {
        this.titelRecensie = titelRecensie;
        this.description = description;
        this.datumTijd = datumTijd;
        this.boek = boek;
        this.lid = lid;
    }

    // Default Constructor
    public RecensieRequest() {}

    // Getters
    public String getTitelRecensie() {
        return titelRecensie;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDatumTijd() {
        return datumTijd;
    }

    public BoekResponse getBoek() {
        return boek;
    }

    public LidResponse getLid() {
        return lid;
    }
}
