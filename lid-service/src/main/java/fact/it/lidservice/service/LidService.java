package fact.it.lidservice.service;

import fact.it.lidservice.dto.LidRequest;
import fact.it.lidservice.dto.LidResponse;
import fact.it.lidservice.model.Lid;
import fact.it.lidservice.repository.LidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LidService {

    private final LidRepository lidRepository;



    public void createLid(LidRequest lidRequest){
       Lid lid = Lid.builder()
                .voornaam(lidRequest.getVoornaam())
                .achternaam(lidRequest.getAchternaam())
                .email(lidRequest.getEmail())
                .build();

        lidRepository.save(lid);
    }

    public List<LidResponse> getAllLids() {
        List<Lid> leden = lidRepository.findAll();

        return leden.stream().map(this::mapToLidResponse).toList();
    }

    public List<LidResponse> getAllLedenByEmail(List<String> email){
        List<Lid> leden = lidRepository.findByEmail(email);

        return leden.stream().map(this::mapToLidResponse).toList();
    }

    public LidResponse getLidById(String id) {
        Lid lid = lidRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lid with ID " + id + " not found"));

        return mapToLidResponse(lid);
    }

    public void updateLid(String id, LidRequest lidRequest) {
        // Zoek het bestaande lid op
        Lid existingLid = lidRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lid with ID " + id + " not found"));

        // Update de velden
        existingLid.setVoornaam(lidRequest.getVoornaam());
        existingLid.setAchternaam(lidRequest.getAchternaam());
        existingLid.setEmail(lidRequest.getEmail());

        // Sla het geüpdatete lid op
        lidRepository.save(existingLid);
    }


    public void deleteLid(String id) {
        if (lidRepository.existsById(id)) {
            lidRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Lid with ID " + id + " not found");
        }
    }


    private LidResponse mapToLidResponse(Lid lid) {
        return LidResponse.builder()
                .id(lid.getId())
                .voornaam(lid.getVoornaam())
                .achternaam(lid.getAchternaam())
                .email(lid.getEmail())
                .build();
    }

}
