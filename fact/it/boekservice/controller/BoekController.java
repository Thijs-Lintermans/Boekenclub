package fact.it.boekservice.controller;

import fact.it.boekService.dto.BoekResponse;
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
        boekService.createBoek(boekRequest)
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
}