package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.BoekResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional
public class BoekService {

    private final WebClient webClient;

    @Value("${boekservice.baseurl}")
    private String boekServiceBaseUrl;

    // Constructor with WebClient.Builder to set base URL dynamically from properties
    public BoekService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(boekServiceBaseUrl).build();
    }

    // Use BoekResponse to map the API response
    public BoekResponse getBoekById(Long boekId) {
        return this.webClient.get()
                .uri("/{id}", boekId)
                .retrieve()
                .bodyToMono(BoekResponse.class)
                .block();
    }
}
