package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.BoekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

@Service
@Transactional
public class BoekService {

    private final WebClient webClient;

/*    @Value("${boekservice.baseurl}")
    private String boekServiceBaseUrl;*/
    private static final String boekServiceBaseUrl = "http://localhost:8082/api/boek";

    public BoekService(Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(boekServiceBaseUrl).build();
    }

    public BoekResponse getBoekById(String boekId) {
        return this.webClient.get()
                .uri("/{id}", boekId)  // baseUrl wordt al door Builder ingesteld
                .retrieve()
                .bodyToMono(BoekResponse.class)
                .block();
    }
}
