package fact.it.lidservice.controller;

import fact.it.lidservice.dto.LidRequest;
import fact.it.lidservice.dto.LidResponse;
import fact.it.lidservice.service.LidService;
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

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<LidResponse> getAllLids() {
        return lidService.getAllLids();
    }
}

