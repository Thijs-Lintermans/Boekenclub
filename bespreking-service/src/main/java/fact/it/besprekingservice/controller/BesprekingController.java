package fact.it.besprekingservice.controller;

import fact.it.besprekingservice.dto.BesprekingRequest;
import fact.it.besprekingservice.dto.BesprekingResponse;
import fact.it.besprekingservice.service.BesprekingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/besprekingen")
@RequiredArgsConstructor
public class BesprekingController {

   private final BesprekingService besprekingService;

   @GetMapping()
   public ResponeEntity<List<BesprekingResponse>> getAllBesprekingen() {
      List<BesprekingResponse> besprekingen = besprekingService.getAllBesprekingen();
      return ResponeEntity.ok(besprekingen);
    }

  @GetMapping("/{id}")
   public ResponeEntity<List<BesprekingResponse>> findById(@PathVariable Long id) {
      BesprekingResponse bespreking = besprekingService.findById(id);
      return ResponeEntity.ok(bespreking);
   }

   @PostMapping
   public ResponeEntity<BesprekingResponse> addBespreking(@RequestBody Bespreking bespreking){
    BesprekingResponse besprekingResponse = besprekingService.addBespreking(bespreking);
    return ResponeEntity.status(HttpStatus.CREATED).body(besprekingResponse);
   }

   @PutMapping("/{id}")
   public ResponeEntity<BesprekingResponse> updateBespreking(@PathVariable Long id, @RequestBody Bespreking bespreking){
    BesprekingResponse besprekingResponse = besprekingService.updateBespreking(id, bespreking);
    return ResponeEntity.ok(besprekingResponse);
   }

   @DeleteMapping("/{id}")
    public ResponeEntity<Void> deleteBespreking(@PathVariable Long id){
     besprekingService.deleteBespreking(id);
     return ResponeEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
