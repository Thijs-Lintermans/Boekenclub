package fact.it.boekservice.controller;

import fact.it.boekservice.dto.BoekRequest;
import fact.it.boekservice.dto.BoekResponse;
import fact.it.boekservice.model.Boek;
import fact.it.boekservice.service.BoekService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/boek")
@RequiredArgsConstructor
public class BoekController {
    private final BoekService boekService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createBoek
            (@RequestBody BoekRequest boekRequest) {
        boekService.createBoek(boekRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BoekResponse> getAllBoekenByTitel
            (@RequestParam List<String> titel) {
        return boekService.getAllBoekenByTitel(titel);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<BoekResponse> getAllBoeken() {
        return boekService.getAllBoeken();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BoekResponse getLidById(@PathVariable String id) {
        return boekService.getBoekById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBoek(@PathVariable String id, @RequestBody BoekRequest boekRequest){
        boekService.updateBoek(id, boekRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBoek(@PathVariable String id) {
        boekService.deleteBoek(id);
    }
}
