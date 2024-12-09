package fact.it.recensieservice.controller;

import fact.it.recensieservice.dto.RecensieResponse;
import fact.it.recensieservice.service.RecensieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recensies")
public class RecensieController {

    private final RecensieService recensieService;

    public RecensieController(RecensieService recensieService) {
        this.recensieService = recensieService;
    }

    // Endpoint om recensies voor een specifiek lid op te halen
    @GetMapping("/{lidId}")
    @ResponseStatus(HttpStatus.OK)
    public List<RecensieResponse> getRecensiesByLidId(@PathVariable String lidId) {
        return recensieService.getRecensiesByLidId(lidId);
    }

    // Endpoint om alle recensies op te halen
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecensieResponse> getAllRecensies() {
        return recensieService.getAllRecensies();
    }
}

