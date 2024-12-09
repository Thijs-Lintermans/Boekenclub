package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.BoekResponse;
import fact.it.recensieservice.dto.LidResponse;
import fact.it.recensieservice.dto.RecensieResponse;
import fact.it.recensieservice.model.Recensie;
import fact.it.recensieservice.repository.RecensieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecensieService {

    private final RecensieRepository recensieRepository;
    private final BoekService boekService;
    private final LidService lidService;

    // Constructor
    public RecensieService(RecensieRepository recensieRepository, BoekService boekService, LidService lidService) {
        this.recensieRepository = recensieRepository;
        this.boekService = boekService;
        this.lidService = lidService;
    }

    public List<RecensieResponse> getAllRecensies() {
        List<Recensie> recensies = recensieRepository.findAll();

        return recensies.stream().map(recensie -> {
            // Retrieve associated Boek and Lid details
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
        }).collect(Collectors.toList());
    }

    // Haal alle recensies voor een lid op
    public List<RecensieResponse> getRecensiesByLidId(String lidId) {
        // Zoek alle recensies voor het opgegeven lid
        List<Recensie> recensies = recensieRepository.findByLidId(lidId);

        // Controleer of er recensies gevonden zijn
        if (recensies.isEmpty()) {
            throw new IllegalArgumentException("Geen recensies gevonden voor dit lid.");
        }

        // Zet de recensies om naar RecensieResponse objecten
        return recensies.stream().map(recensie -> {
            // Haal het boek op voor de recensie
            BoekResponse boek = boekService.getBoekById(recensie.getBoekId());

            // Haal het lid op voor de recensie
            LidResponse lid = lidService.getLidById(recensie.getLidId());

            return new RecensieResponse(
                    recensie.getId(),
                    recensie.getTitelRecensie(),
                    recensie.getDescription(),
                    recensie.getDatumTijd(),
                    boek,
                    lid
            );
        }).collect(Collectors.toList());
    }

    // Seed database with initial data
    @PostConstruct
    public void loadInitialData() {
        System.out.println("Seeding initial data...");
        if (recensieRepository.count() == 0) {
            try {
                // Example Lid and Boek IDs
                String lidId1 = "67574551f13cf346e93dbaac";   // Java automatically promotes 1 (int) to Long
                String lidId2 = "67574566f13cf346e93dbaad";
                String boekId1 = "6753631ff560ca1281479d0b";
                String boekId2 = "675746c20ac9ea19bdad821c";

                // Check if Lid and Boek exist
                LidResponse lid1 = lidService.getLidById(lidId1);
                LidResponse lid2 = lidService.getLidById(lidId2);
                BoekResponse boek1 = boekService.getBoekById(boekId1);
                BoekResponse boek2 = boekService.getBoekById(boekId2);

                // Create and save example recensies
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
