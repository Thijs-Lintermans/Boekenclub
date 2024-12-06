package fact.it.recensieservice.service;

import fact.it.recensieservice.dto.RecensieResponse;
import fact.it.recensieservice.model.Recensie;
import fact.it.recensieservice.repository.RecensieRepository;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecensieService {
    private final RecensieRepository recensieRepository;

    @Transactional(readOnly = true)
    public List<RecensieResponse> getAllRecensies() {
       return recensieRepository.findAll().stream()
                .map(recensie -> RecensieResponse.builder()
                        .id(recensie.getId())
                        .titelRecensie(recensie.getTitelRecensie())
                        .description(recensie.getDescription())
                        .datum(recensie.getDatum())
                        .lidId(recensie.getLidId())
                        .boekId(recensie.getBoekId())
                        .build())
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public RecensieResponse findById(Long id) {
        Recensie recensie = recensieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recensie met id " + id + " niet gevonden"));
        return RecensieResponse.builder()
                .id(recensie.getId())
                .titelRecensie(recensie.getTitelRecensie())
                .description(recensie.getDescription())
                .datum(recensie.getDatum())
                .lidId(recensie.getLidId())
                .boekId(recensie.getBoekId())
                .build();
    }
    @Transactional
    public RecensieResponse addRecensie(Recensie recensie) {
        Recensie createdRecensie = recensieRepository.save(recensie);
        return RecensieResponse.builder()
                .id(createdRecensie.getId())
                .titelRecensie(createdRecensie.getTitelRecensie())
                .description(createdRecensie.getDescription())
                .datum(createdRecensie.getDatum())
                .lidId(createdRecensie.getLidId())
                .boekId(createdRecensie.getBoekId())
                .build();
    }
    @Transactional
    public RecensieResponse updateRecensie(Long id, Recensie updatedRecensie) {
        Recensie recensie = recensieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recensie met id " + id + " niet gevonden"));
        recensie.setTitelRecensie(updatedRecensie.getTitelRecensie());
        recensie.setDescription(updatedRecensie.getDescription());
        recensie.setDatum(updatedRecensie.getDatum());
        recensie.setLidId(updatedRecensie.getLidId());
        recensie.setBoekId(updatedRecensie.getBoekId());
        Recensie updatedRecensie = recensieRepository.save(recensie);
        return RecensieResponse.builder()
                .id(updatedRecensie.getId())
                .titelRecensie(updatedRecensie.getTitelRecensie())
                .description(updatedRecensie.getDescription())
                .datum(updatedRecensie.getDatum())
                .lidId(updatedRecensie.getLidId())
                .boekId(updatedRecensie.getBoekId())
                .build();
    }
    @Transactional
    public void deleteRecensie(Long id) {
        Recensie recensie = recensieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recensie met id " + id + " niet gevonden"));
        recensieRepository.delete(recensie);
    }
}