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

        productRepository.save(product);
    }

    public List<LidResponse> getAllLids() {
        List<Lid> lids = lidReository.findAll();

        return lids.stream().map(this::mapToLidResponse).toList();
    }

    privateLidResponse mapToLidResponse(Lid lid) {
        return LidResponse.builder()
                .id(lid.getId())
                .voornaam(lid.getVoornaam())
                .achternaam(lid.getAchternaam())
                .email(lid.getEmail())
                .build();
    }

}
