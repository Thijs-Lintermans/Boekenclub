package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.LidResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional
public class LidService {

    private final WebClient webClient;

    @Value("${lidservice.baseurl}")
    private String lidServiceBaseUrl;


    // Fetch Lid data using WebClient and return LidResponse
    public LidResponse getLidById(Long lidId) {
        return this.webClient.get()
                .uri("/{id}", lidId)
                .retrieve()
                .bodyToMono(LidResponse.class)
                .block(); // Blocking for simplicity; prefer reactive in production
    }
}
