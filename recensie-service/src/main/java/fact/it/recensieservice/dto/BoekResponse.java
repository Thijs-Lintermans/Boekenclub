package fact.it.recensieservice.dto;

import java.time.LocalDate;
import java.util.Date;

public class BoekResponse {
    private String id;
    private String titel;
    private String auteur;
    private String genre;
    private LocalDate publicatieDatum;
    private Integer aantalPaginas;

    // Default constructor
    public BoekResponse() {
    }

    // All arguments constructor
    public BoekResponse(String id, String titel, String auteur, String genre, LocalDate publicatieDatum, Integer aantalPaginas) {
        this.id = id;
        this.titel = titel;
        this.auteur = auteur;
        this.genre = genre;
        this.publicatieDatum = publicatieDatum;
        this.aantalPaginas = aantalPaginas;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getPublicatieDatum() {
        return publicatieDatum;
    }

    public Integer getAantalPaginas() {
        return aantalPaginas;
    }

    // Builder pattern (using Lombok would automatically generate this)
    public static class Builder {
        private String id;
        private String titel;
        private String auteur;
        private String genre;
        private LocalDate publicatieDatum;
        private Integer aantalPaginas;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder titel(String titel) {
            this.titel = titel;
            return this;
        }

        public Builder auteur(String auteur) {
            this.auteur = auteur;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder publicatieDatum(LocalDate publicatieDatum) {
            this.publicatieDatum = publicatieDatum;
            return this;
        }

        public Builder aantalPaginas(Integer aantalPaginas) {
            this.aantalPaginas = aantalPaginas;
            return this;
        }

        public BoekResponse build() {
            return new BoekResponse(id, titel, auteur, genre, publicatieDatum, aantalPaginas);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

