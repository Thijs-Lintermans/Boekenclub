package fact.it.besprekingservice.controller;

import fact.it.besprekingservice.dto.BesprekingRequest;
import fact.it.besprekingservice.dto.BesprekingResponse;
import fact.it.besprekingservice.service.BesprekingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bespreking")
@RequiredArgsConstructor
public class BesprekingController {

    private final BesprekingService besprekingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BesprekingResponse> getAllBesprekingen() {
        return besprekingService.getAllBesprekingen();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BesprekingResponse getBesprekingById(@PathVariable Long id) {
        return besprekingService.getBesprekingById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createBespreking(@RequestBody BesprekingRequest besprekingRequest) {
        boolean result = besprekingService.createBespreking(besprekingRequest);
        return result ? "Bespreking succesvol aangemaakt" : "Bespreking niet succesvol aangemaakt";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBespreking(@PathVariable Long id, @RequestBody BesprekingRequest besprekingRequest) {
        besprekingService.updateBespreking(id, besprekingRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBespreking(@PathVariable Long id) {
        besprekingService.deleteBespreking(id);
    }
}
