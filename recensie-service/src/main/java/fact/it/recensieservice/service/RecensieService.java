package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.BoekResponse;
import fact.it.recensieservice.dto.LidResponse;
import fact.it.recensieservice.dto.RecensieResponse;
import fact.it.recensieservice.model.Recensie;
import fact.it.recensieservice.repository.RecensieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RecensieService {

    private final RecensieRepository recensieRepository;
    private final BoekService boekService;  // Inject BoekService
    private final LidService lidService;    // Inject LidService

    public RecensieResponse getRecensieByLidId(Long id) {
        Recensie recensie = recensieRepository.findByLidId(id)
                .orElseThrow(() -> new IllegalArgumentException("Recensie not found"));

        // Use BoekService to get Boek data
        BoekResponse boek = boekService.getBoekById(recensie.getBoekId());

        // Use LidService to get Lid data
        LidResponse lid = lidService.getLidById(recensie.getLidId());

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
