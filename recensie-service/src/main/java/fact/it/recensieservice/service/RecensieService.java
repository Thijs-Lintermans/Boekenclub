package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.BoekResponse;
import fact.it.recensieservice.dto.LidResponse;
import fact.it.recensieservice.dto.RecensieResponse;
import fact.it.recensieservice.model.Recensie;
import fact.it.recensieservice.repository.RecensieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecensieService {

    private final RecensieRepository recensieRepository;
    private final BoekService boekService;  // Inject BoekService
    private final LidService lidService;    // Inject LidService

    // Constructor
    public RecensieService(RecensieRepository recensieRepository, BoekService boekService, LidService lidService) {
        this.recensieRepository = recensieRepository;
        this.boekService = boekService;
        this.lidService = lidService;
    }

    public RecensieResponse getRecensieByLidId(Long id) {
        Recensie recensie = recensieRepository.findByLidId(id)
                .orElseThrow(() -> new IllegalArgumentException("Recensie not found"));

        // Use BoekService to get Boek data
        BoekResponse boek = boekService.getBoekById(recensie.getBoekId());

        // Use LidService to get Lid data
        LidResponse lid = lidService.getLidById(recensie.getLidId());

        // Use constructor instead of builder
        return new RecensieResponse(
                recensie.getId(),
                recensie.getTitelRecensie(),
                recensie.getDescription(),
                recensie.getDatumTijd(),
                boek, // Embed BoekResponse
                lid    // Embed LidResponse
        );
    }
}
