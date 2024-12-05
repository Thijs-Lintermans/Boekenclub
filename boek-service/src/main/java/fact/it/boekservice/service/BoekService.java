package fact.it.boekservice.service;

import fact.it.boekservice.dto.BoekRequest;
import fact.it.boekservice.dto.BoekResponse;
import fact.it.boekservice.model.Boek;
import fact.it.boekservice.repository.BoekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoekService {

    private final BoekRepository boekRepository;

    public void createBoek(BoekRequest boekRequest){
        Boek boek = Boek.builder()
                .titel(boekRequest.getTitel())
                .auteur(boekRequest.getAuteur())
                .genre(boekRequest.getGenre())
                .publicatieDatum(boekRequest.getPublicatieDatum())
                .aantalPaginas(boekRequest.getAantalPaginas())
                .build();
        boekRepository.save(boek);
    }

    public List<BoekResponse> getAllBoeken(){
        List<Boek> boeken = boekRepository.findAll();

        return boeken.stream().map(this::mapToBoekResponse).toList();
    }

    public List<BoekResponse> getAllBoekenByTitel(List<String> titel) {
        List<Boek> boeken = boekRepository.findByTitel(titel);

        return boeken.stream().map(this::mapToBoekResponse).toList();
    }

    public void updateBoek(String id, BoekRequest boekRequest) {

        Boek existingBoek = boekRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Boek with ID " + id + " not found"));


        existingBoek.setTitel(boekRequest.getTitel());
        existingBoek.setAuteur(boekRequest.getAuteur());
        existingBoek.setGenre(boekRequest.getGenre());
        existingBoek.setPublicatieDatum(boekRequest.getPublicatieDatum());
        existingBoek.setAantalPaginas(boekRequest.getAantalPaginas());

        boekRepository.save(existingBoek);
    }

    public BoekResponse getBoekById(String id) {
        Boek boek = boekRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Boek with ID " + id + " not found"));

        return mapToBoekResponse(boek);
    }

    public void deleteBoek(String id) {
        if (boekRepository.existsById(id)) {
            boekRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Boek with ID " + id + " not found");
        }
    }


    private BoekResponse mapToBoekResponse(Boek boek){
        return BoekResponse.builder()
                .id(boek.getId())
                .titel(boek.getTitel())
                .auteur(boek.getAuteur())
                .genre(boek.getGenre())
                .publicatieDatum(boek.getPublicatieDatum())
                .aantalPaginas(boek.getAantalPaginas())
                .build();
    }
}