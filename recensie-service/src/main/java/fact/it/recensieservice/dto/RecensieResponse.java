package fact.it.recensieservice.dto;

import java.time.LocalDateTime;


public class RecensieResponse {
    private Long id;
    private String titelRecensie;
    private String description;
    private LocalDateTime datumTijd;
    private BoekResponse boek;
    private LidResponse lid;

    // Constructor
    public RecensieResponse(Long id, String titelRecensie, String description, LocalDateTime datumTijd, BoekResponse boek, LidResponse lid) {
        this.id = id;
        this.titelRecensie = titelRecensie;
        this.description = description;
        this.datumTijd = datumTijd;
        this.boek = boek;
        this.lid = lid;
    }

    // Getters and Setters

    public static class Builder {
        private Long id;
        private String titelRecensie;
        private String description;
        private LocalDateTime datumTijd;
        private BoekResponse boek;
        private LidResponse lid;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder titelRecensie(String titelRecensie) {
            this.titelRecensie = titelRecensie;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder datumTijd(LocalDateTime datumTijd) {
            this.datumTijd = datumTijd;
            return this;
        }

        public Builder boek(BoekResponse boek) {
            this.boek = boek;
            return this;
        }

        public Builder lid(LidResponse lid) {
            this.lid = lid;
            return this;
        }

        public RecensieResponse build() {
            return new RecensieResponse(id, titelRecensie, description, datumTijd, boek, lid);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

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
