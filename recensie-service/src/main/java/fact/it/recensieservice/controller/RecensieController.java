package fact.it.recensieservice.controller;

import fact.it.recensieservice.dto.RecensieRequest;
import fact.it.recensieservice.dto.RecensieResponse;
import fact.it.recensieservice.service.RecensieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recensies")
@RequiredArgsConstructor
public class RecensieController {
    private final RecensieService recensieService;

    @GetMapping
    public ResponseEntity<List<RecensieResponse>> getAllRecensies() {
        List<RecensieResponse> recensies = recensieService.getAllRecensies();
        return recensieService.getAllRecensies();
    }

    @GetMapping("/{id}")
    public RecensieResponse getRecensieById(@PathVariable Long id) {
        return recensieService.getRecensieById(id);
    }

    @PostMapping
    public ResponseEntity<RecensieResponse> addRecensie(@RequestBody Recensie recensie) {
        RecensieResponse createdRecensie = recensieService.addRecensie(recensie);
        return ResponseEntity.status(201).body(createdRecensie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecensieResponse> updateRecensie(@PathVariable Long id, @RequestBody Recensie updatedRecensie) {
        RecensieResponse recensie = recensieService.updateRecensie(id, updatedRecensie);
        return ResponseEntity.ok(recensie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecensie(@PathVariable Long id) {
        recensieService.deleteRecensie(id);
        return ResponseEntity.noContent().build();
    }
}