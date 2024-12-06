package fact.it.besprekingservice.service;

import fact.it.besprekingservice.dto.BesprekingResponse;
import fact.it.besprekingservice.model.Bespreking;
import fact.it.besprekingservice.repository.BesprekingRepository;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BesprekingService {

    private final BesprekingRepository besprekingRepository;

    @Transactional(readOnly = true)
    public List<BesprekingResponse> getAllBesprekingen() {
        return besprekingRepository.findAll().stream()
                .map(bespreking -> BesprekingResponse.builder()
                        .id(bespreking.getId())
                        .titelBespreking(bespreking.getTitelBespreking())
                        .datum(bespreking.getDatum())
                        .locatie(bespreking.getLocatie())
                        .omschrijving(bespreking.getOmschrijving())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BesprekingResponse findById(Long id) {
        Bespreking bespreking = besprekingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Bespreking met id " + id + " niet gevonden"));
        return BesprekingResponse.builder()
                .id(bespreking.getId())
                .titelBespreking(bespreking.getTitelBespreking())
                .datum(bespreking.getDatum())
                .locatie(bespreking.getLocatie())
                .omschrijving(bespreking.getOmschrijving())
                .build();
    }

    @Transactional
    public BesprekingResponse addBespreking(Bespreking bespreking) {
        Bespreking savedBespreking = besprekingRepository.save(bespreking);
        return BesprekingResponse.builder()
                .id(savedBespreking.getId())
                .titelBespreking(savedBespreking.getTitelBespreking())
                .datum(savedBespreking.getDatum())
                .locatie(savedBespreking.getLocatie())
                .omschrijving(savedBespreking.getOmschrijving())
                .build();
    }

    @Transactional
    public BesprekingResponse updateBespreking(Long id, Bespreking bespreking) {
        Bespreking besprekingToUpdate = besprekingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Bespreking met id " + id + " niet gevonden"));
        besprekingToUpdate.setTitelBespreking(bespreking.getTitelBespreking());
        besprekingToUpdate.setDatum(bespreking.getDatum());
        besprekingToUpdate.setLocatie(bespreking.getLocatie());
        besprekingToUpdate.setOmschrijving(bespreking.getOmschrijving());
        Bespreking savedBespreking = besprekingRepository.save(besprekingToUpdate);
        return BesprekingResponse.builder()
                .id(savedBespreking.getId())
                .titelBespreking(savedBespreking.getTitelBespreking())
                .datum(savedBespreking.getDatum())
                .locatie(savedBespreking.getLocatie())
                .omschrijving(savedBespreking.getOmschrijving())
                .build();
    }
    @Transactional
    public void deleteBespreking(Long id) {
       Bespreking bestaandeBespreking = besprekingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Bespreking met id " + id + " niet gevonden"));

       besprekingRepository.delete(bestaandeBespreking);
    }
}
