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

    // This constructor is no longer needed because @RequiredArgsConstructor generates it automatically

    public BoekResponse getBoekById(Long boekId) {
        return this.webClient.get()
                .uri(boekServiceBaseUrl + "/{id}", boekId) // Use base URL injected via @Value
                .retrieve()
                .bodyToMono(BoekResponse.class)
                .block();
    }
}
