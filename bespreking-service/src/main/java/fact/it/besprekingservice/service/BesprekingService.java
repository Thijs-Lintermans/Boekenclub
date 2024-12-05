//package fact.it.besprekingservice.service;
//
//import fact.it.besprekingservice.dto.BesprekingRequest;
//import fact.it.besprekingservice.dto.BesprekingResponse;
//import fact.it.besprekingservice.model.Bespreking;
//import fact.it.besprekingservice.repository.BesprekingRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class BesprekingService {
//
//    private final BesprekingRepository besprekingRepository;
//    // Create Bespreking
//    public boolean createBespreking(BesprekingRequest besprekingRequest){
//        Bespreking bespreking = Bespreking.builder()
//                .titelBespreking(besprekingRequest.getTitelBespreking())
//                .datum(besprekingRequest.getDatum())
//                .locatie(besprekingRequest.getLocatie())
//                .omschrijving(besprekingRequest.getOmschrijving())
//                .build();
//        besprekingRepository.save(bespreking);
//        return true;
//    }
//
//    public List<BoekResponse> getAllBoeken(){
//        List<Boek> boeken = boekRepository.findAll();
//
//        return boeken.stream().map(this::mapToBoekResponse).toList();
//    }
//
//    public List<BoekResponse> getAllBoekenByTitel(List<String> titel) {
//        List<Boek> boeken = boekRepository.findByTitel(titel);
//
//        return boeken.stream().map(this::mapToBoekResponse).toList();
//    }
//
//    public void updateBoek(String id, BoekRequest boekRequest) {
//
//        Boek existingBoek = boekRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Boek with ID " + id + " not found"));
//
//
//        existingBoek.setTitel(boekRequest.getTitel());
//        existingBoek.setAuteur(boekRequest.getAuteur());
//        existingBoek.setGenre(boekRequest.getGenre());
//        existingBoek.setPublicatieDatum(boekRequest.getPublicatieDatum());
//        existingBoek.setAantalPaginas(boekRequest.getAantalPaginas());
//
//        boekRepository.save(existingBoek);
//    }
//
//    public BoekResponse getBoekById(String id) {
//        Boek boek = boekRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Boek with ID " + id + " not found"));
//
//        return mapToBoekResponse(boek);
//    }
//
//    public void deleteBoek(String id) {
//        if (boekRepository.existsById(id)) {
//            boekRepository.deleteById(id);
//        } else {
//            throw new IllegalArgumentException("Boek with ID " + id + " not found");
//        }
//    }
//
//
//    private BoekResponse mapToBoekResponse(Boek boek){
//        return BoekResponse.builder()
//                .id(boek.getId())
//                .titel(boek.getTitel())
//                .auteur(boek.getAuteur())
//                .genre(boek.getGenre())
//                .publicatieDatum(boek.getPublicatieDatum())
//                .aantalPaginas(boek.getAantalPaginas())
//                .build();
//    }
//}