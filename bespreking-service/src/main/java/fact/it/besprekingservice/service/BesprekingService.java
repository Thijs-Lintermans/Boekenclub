package fact.it.besprekingservice.service;

import fact.it.besprekingservice.dto.BesprekingResponse;
import fact.it.besprekingservice.dto.BesprekingRequest;
import fact.it.besprekingservice.model.Bespreking;
import fact.it.besprekingservice.repository.BesprekingRepository;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BesprekingService {

    private final BesprekingRepository besprekingRepository;

    @Transactional(readOnly = true)
    public List<BesprekingResponse> getAllBesprekingen() {
        List<Bespreking> besprekingen = besprekingRepository.findAll();
        return besprekingen.stream()
                .map(this::mapToBesprekingResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BesprekingResponse getBesprekingById(Long id) {
        Bespreking bespreking = besprekingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bespreking met id " + id + " niet gevonden"));
        return mapToBesprekingResponse(bespreking);
    }

    public boolean createBespreking(BesprekingRequest besprekingRequest) {
        Bespreking bespreking = new Bespreking();
        bespreking.setTitelBespreking(besprekingRequest.getTitelBespreking());
        bespreking.setDatum(besprekingRequest.getDatum());
        bespreking.setLocatie(besprekingRequest.getLocatie());
        bespreking.setOmschrijving(besprekingRequest.getOmschrijving());
        besprekingRepository.save(bespreking);
        return true;
    }

    public void updateBespreking(Long id, BesprekingRequest besprekingRequest) {
        Bespreking bestaandeBespreking = besprekingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bespreking met id " + id + " niet gevonden"));

        bestaandeBespreking.setTitelBespreking(besprekingRequest.getTitelBespreking());
        bestaandeBespreking.setDatum(besprekingRequest.getDatum());
        bestaandeBespreking.setLocatie(besprekingRequest.getLocatie());
        bestaandeBespreking.setOmschrijving(besprekingRequest.getOmschrijving());

        besprekingRepository.save(bestaandeBespreking);
    }

    @Transactional
    public void deleteBespreking(Long id) {
        if (!besprekingRepository.existsById(id)) {
            throw new IllegalArgumentException("Bespreking met id " + id + " niet gevonden");
        }
        besprekingRepository.deleteById(id);
    }

    private BesprekingResponse mapToBesprekingResponse(Bespreking bespreking) {
        return BesprekingResponse.builder()
                .id(bespreking.getId())
                .titelBespreking(bespreking.getTitelBespreking())
                .datum(bespreking.getDatum())
                .locatie(bespreking.getLocatie())
                .omschrijving(bespreking.getOmschrijving())
                .build();
    }
}
