package fact.it.recensieservice.dto;

public class LidResponse {
    private String id;
    private String voornaam;
    private String achternaam;
    private String email;

    // Default constructor
    public LidResponse() {
    }

    // All arguments constructor
    public LidResponse(String id, String voornaam, String achternaam, String email) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Builder pattern
    public static class Builder {
        private String id;
        private String voornaam;
        private String achternaam;
        private String email;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder voornaam(String voornaam) {
            this.voornaam = voornaam;
            return this;
        }

        public Builder achternaam(String achternaam) {
            this.achternaam = achternaam;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public LidResponse build() {
            return new LidResponse(id, voornaam, achternaam, email);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
