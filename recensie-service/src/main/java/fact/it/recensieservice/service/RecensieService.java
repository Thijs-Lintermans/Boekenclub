package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.BoekResponse;
import fact.it.recensieservice.dto.LidResponse;
import fact.it.recensieservice.dto.RecensieRequest;
import fact.it.recensieservice.dto.RecensieResponse;
import fact.it.recensieservice.model.Recensie;
import fact.it.recensieservice.repository.RecensieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecensieService {

    private final RecensieRepository recensieRepository;
    private final BoekService boekService;
    private final LidService lidService;

    public RecensieService(RecensieRepository recensieRepository, BoekService boekService, LidService lidService) {
        this.recensieRepository = recensieRepository;
        this.boekService = boekService;
        this.lidService = lidService;
    }

    public List<RecensieResponse> getAllRecensies() {
        return recensieRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<RecensieResponse> getRecensiesByLidId(String lidId) {
        List<Recensie> recensies = recensieRepository.findByLidId(lidId);
        if (recensies.isEmpty()) {
            throw new IllegalArgumentException("Geen recensies gevonden voor dit lid.");
        }
        return recensies.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public RecensieResponse createRecensie(RecensieRequest recensieRequest) {
        if (recensieRequest.getLidId() == null || recensieRequest.getBoekId() == null) {
            throw new IllegalArgumentException("LidId and BoekId are required and cannot be null.");
        }

        // Validate the Lid and Boek existence using the provided IDs
        LidResponse lid = lidService.getLidById(recensieRequest.getLidId());
        BoekResponse boek = boekService.getBoekById(recensieRequest.getBoekId());

        Recensie recensie = new Recensie(
                recensieRequest.getTitelRecensie(),
                recensieRequest.getDescription(),
                LocalDateTime.now(),
                recensieRequest.getLidId(),
                recensieRequest.getBoekId()
        );

        Recensie savedRecensie = recensieRepository.save(recensie);
        return mapToResponse(savedRecensie);
    }


    public RecensieResponse updateRecensie(String recensieId, RecensieRequest recensieRequest) {
        Recensie recensie = recensieRepository.findById(recensieId)
                .orElseThrow(() -> new IllegalArgumentException("Recensie met ID " + recensieId + " niet gevonden."));

        // Validate Lid and Boek existence
        LidResponse lid = lidService.getLidById(recensieRequest.getLidId()); // Directly use the Lid ID
        BoekResponse boek = boekService.getBoekById(recensieRequest.getBoekId()); // Directly use the Boek ID

        recensie.setTitelRecensie(recensieRequest.getTitelRecensie());
        recensie.setDescription(recensieRequest.getDescription());
        recensie.setLidId(lid.getId()); // Correct setter for lidId
        recensie.setBoekId(boek.getId()); // Correct setter for boekId
        recensie.setDatumTijd(LocalDateTime.now());

        Recensie updatedRecensie = recensieRepository.save(recensie);
        return mapToResponse(updatedRecensie);
    }

    public void deleteRecensie(String recensieId) {
        Recensie recensie = recensieRepository.findById(recensieId)
                .orElseThrow(() -> new IllegalArgumentException("Recensie met ID " + recensieId + " niet gevonden"));

        recensieRepository.deleteById(recensieId);
    }

    private RecensieResponse mapToResponse(Recensie recensie) {
        BoekResponse boek = boekService.getBoekById(recensie.getBoekId());
        LidResponse lid = lidService.getLidById(recensie.getLidId());

        return new RecensieResponse(
                recensie.getId(),
                recensie.getTitelRecensie(),
                recensie.getDescription(),
                recensie.getDatumTijd(),
                boek,
                lid
        );
    }

    @PostConstruct
    public void loadInitialData() {
        System.out.println("Seeding initial data...");
        if (recensieRepository.count() == 0) {
            try {
                String lidId1 = "67574551f13cf346e93dbaac";
                String lidId2 = "67574566f13cf346e93dbaad";
                String boekId1 = "6753631ff560ca1281479d0b";
                String boekId2 = "675746c20ac9ea19bdad821c";

                // Validate existence of the Lid and Boek before creating recensies
                LidResponse lid1 = lidService.getLidById(lidId1);
                LidResponse lid2 = lidService.getLidById(lidId2);
                BoekResponse boek1 = boekService.getBoekById(boekId1);
                BoekResponse boek2 = boekService.getBoekById(boekId2);

                Recensie recensie1 = new Recensie("Engaging Read", "Loved every bit of it!", LocalDateTime.now().minusDays(5), lidId1, boekId1);
                Recensie recensie2 = new Recensie("Average Book", "It was okay but not great.", LocalDateTime.now().minusDays(10), lidId2, boekId1);
                Recensie recensie3 = new Recensie("Fantastic!", "Highly recommend this book!", LocalDateTime.now().minusDays(3), lidId1, boekId2);

                recensieRepository.saveAll(List.of(recensie1, recensie2, recensie3));
            } catch (Exception e) {
                System.err.println("Error seeding data: " + e.getMessage());
            }
        }
    }
}
