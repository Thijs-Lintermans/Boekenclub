package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.LidResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

@Service
@Transactional
public class LidService {

    private final WebClient webClient;

    @Value("${lidservice.baseurl}")
    private String lidServiceBaseUrl;

    // Inject WebClient.Builder
    public LidService(Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(lidServiceBaseUrl).build(); // Configureer WebClient met baseUrl
    }

    // Fetch Lid data using WebClient and return LidResponse
    public LidResponse getLidById(Long lidId) {
        return this.webClient.get()
                .uri("/{id}", lidId) // baseUrl is al ingesteld in de builder
                .retrieve()
                .bodyToMono(LidResponse.class)
                .block(); // Blocking for simplicity; prefer reactive in production
    }
}
