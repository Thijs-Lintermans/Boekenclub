package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.BoekResponse;
import fact.it.recensieservice.dto.LidResponse;
import fact.it.recensieservice.dto.RecensieResponse;
import fact.it.recensieservice.model.Recensie;
import fact.it.recensieservice.repository.RecensieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Transactional
public class RecensieService {

    private final RecensieRepository recensieRepository;
    private final WebClient webClient; // Use WebClient instead of RestTemplate

    public RecensieResponse getRecensieByLidId(Long id) {
        Recensie recensie = recensieRepository.findByLidId(id)
                .orElseThrow(() -> new IllegalArgumentException("Recensie not found"));

        // Fetch Boek data using WebClient
        BoekResponse boek = webClient.get()
                .uri("http://boekservice/api/boeken/{id}", recensie.getBoekId())
                .retrieve()
                .bodyToMono(BoekResponse.class)
                .block();

        // Fetch Lid data using WebClient
        LidResponse lid = webClient.get()
                .uri("http://lidservice/api/leden/{id}", recensie.getLidId())
                .retrieve()
                .bodyToMono(LidResponse.class)
                .block();

        // Build RecensieResponse
        return RecensieResponse.builder()
                .id(recensie.getId())
                .titelRecensie(recensie.getTitelRecensie())
                .description(recensie.getDescription())
                .datumTijd(recensie.getDatumTijd())
                .boek(boek) // Embed BoekResponse
                .lid(lid)   // Embed LidResponse
                .build();
    }
}

