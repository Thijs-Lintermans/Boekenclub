//package fact.it.besprekingservice.controller;
//
//import fact.it.besprekingservice.dto.BesprekingRequest;
//import fact.it.besprekingservice.dto.BesprekingResponse;
//import fact.it.besprekingservice.service.BesprekingService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/bespreking")
//@RequiredArgsConstructor
//public class BesprekingController {
//
//    private final BesprekingService besprekingService;
//
//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public List<BesprekingResponse> getAllBesprekingen() {
//        return besprekingService.getAllBesprekingen();
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.OK)
//    public String createBespreking(@RequestBody BesprekingRequest besprekingRequest) {
//        boolean result = besprekingService.createBespreking(besprekingRequest);
//        return (result ? "Bespreking succesvol aangemaakt" : "Bespreking niet succesvol aangemaakt");
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public String updateBespreking(@PathVariable Long id, @RequestBody BesprekingRequest besprekingRequest) {
//        besprekingService.updateBespreking(id, besprekingRequest);
//        return "Bespreking succesvol bijgewerkt";
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public String deleteBespreking(@PathVariable Long id) {
//        besprekingService.deleteBespreking(id);
//        return "Bespreking succesvol verwijderd";
//    }
//
//
//
//
//}
