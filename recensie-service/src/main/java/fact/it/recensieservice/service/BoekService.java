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

    @Value("${boekservice.baseurl}")
    private String boekServiceBaseUrl;

    public BoekService(Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(boekServiceBaseUrl).build();
    }

    public BoekResponse getBoekById(String boekId) {
        return webClient.get()
                .uri("http://" + boekServiceBaseUrl + "/api/boek/", boekId) // Dynamisch baseUrl
                .retrieve()
                .bodyToMono(BoekResponse.class)
                .block();
    }

}
