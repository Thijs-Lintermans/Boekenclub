package fact.it.lidservice.controller;

import fact.it.lidservice.dto.LidRequest;
import fact.it.lidservice.dto.LidResponse;
import fact.it.lidservice.model.Lid;
import fact.it.lidservice.service.LidService;
import fact.it.lidservice.repository.LidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lid")
@RequiredArgsConstructor
public class LidController {

    private final LidService lidService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createLid
            (@RequestBody LidRequest lidRequest) {
        lidService.createLid(lidRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LidResponse> getAllLedenByEmail
            (@RequestParam List<String> email){
        return lidService.getAllLedenByEmail(email);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LidResponse getLidById(@PathVariable String id) {
        return lidService.getLidById(id); // Roep de service aan om het lid op te halen
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<LidResponse> getAllLids() {
        return lidService.getAllLids();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLid(@PathVariable String id, @RequestBody LidRequest lidRequest){
        lidService.updateLid(id, lidRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLid(@PathVariable String id) {
        lidService.deleteLid(id);
    }
}

