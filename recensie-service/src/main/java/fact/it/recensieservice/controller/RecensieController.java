package fact.it.recensieservice.controller;

import fact.it.recensieservice.dto.RecensieResponse;
import fact.it.recensieservice.service.RecensieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recensie")
@RequiredArgsConstructor
public class RecensieController {

    private final RecensieService recensieService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecensieResponse getRecensie(@PathVariable("id") Long lidId){
        return recensieService.getRecensieByLidId(lidId);
    }
}
