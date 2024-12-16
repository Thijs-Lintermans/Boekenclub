package fact.it.besprekingservice;

import fact.it.besprekingservice.dto.BesprekingRequest;
import fact.it.besprekingservice.dto.BesprekingResponse;
import fact.it.besprekingservice.model.Bespreking;
import fact.it.besprekingservice.repository.BesprekingRepository;
import fact.it.besprekingservice.service.BesprekingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BesprekingServiceUnitTests {
    @InjectMocks
    private BesprekingService besprekingService;

    @Mock
    private BesprekingRepository besprekingRepository;

    @Test
    public void testCreateBespreking() {
        // Arrange
        BesprekingRequest besprekingRequest = new BesprekingRequest();
        besprekingRequest.setTitelBespreking("Test Titel");
        besprekingRequest.setDatum("2024-12-10");
        besprekingRequest.setLocatie("Test Locatie");
        besprekingRequest.setOmschrijving("Test Omschrijving");

        // Act
        boolean result = besprekingService.createBespreking(besprekingRequest);

        // Assert
        assertTrue(result);
        verify(besprekingRepository, times(1)).save(any(Bespreking.class));
    }

    @Test
    public void testGetAllBesprekingen() {
        // Arrange
        Bespreking bespreking = new Bespreking();
        bespreking.setId(1L);
        bespreking.setTitelBespreking("Test Titel");
        bespreking.setDatum("2024-12-10");
        bespreking.setLocatie("Test Locatie");
        bespreking.setOmschrijving("Test Omschrijving");

        when(besprekingRepository.findAll()).thenReturn(Arrays.asList(bespreking));

        // Act
        List<BesprekingResponse> besprekingen = besprekingService.getAllBesprekingen();

        // Assert
        assertEquals(1, besprekingen.size());
        assertEquals("Test Titel", besprekingen.get(0).getTitelBespreking());
        assertEquals("Test Locatie", besprekingen.get(0).getLocatie());
        assertEquals("Test Omschrijving", besprekingen.get(0).getOmschrijving());

        verify(besprekingRepository, times(1)).findAll();
    }

    @Test
    public void testGetBesprekingById() {
        // Arrange
        Bespreking bespreking = new Bespreking();
        bespreking.setId(1L);
        bespreking.setTitelBespreking("Test Titel");
        bespreking.setDatum("2024-12-10");
        bespreking.setLocatie("Test Locatie");
        bespreking.setOmschrijving("Test Omschrijving");

        when(besprekingRepository.findById(1L)).thenReturn(Optional.of(bespreking));

        // Act
        BesprekingResponse response = besprekingService.getBesprekingById(1L);

        // Assert
        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Test Titel", response.getTitelBespreking());
        assertEquals("2024-12-10", response.getDatum());
        assertEquals("Test Locatie", response.getLocatie());
        assertEquals("Test Omschrijving", response.getOmschrijving());

        verify(besprekingRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteBespreking() {
        // Arrange
        when(besprekingRepository.existsById(1L)).thenReturn(true);

        // Act
        besprekingService.deleteBespreking(1L);

        // Assert
        verify(besprekingRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateBespreking() {
        // Arrange
        Bespreking bestaandeBespreking = new Bespreking();
        bestaandeBespreking.setId(1L);
        bestaandeBespreking.setTitelBespreking("Oude Titel");
        bestaandeBespreking.setDatum("2024-12-09");
        bestaandeBespreking.setLocatie("Oude Locatie");
        bestaandeBespreking.setOmschrijving("Oude Omschrijving");

        BesprekingRequest updateRequest = new BesprekingRequest();
        updateRequest.setTitelBespreking("Nieuwe Titel");
        updateRequest.setDatum("2024-12-10");
        updateRequest.setLocatie("Nieuwe Locatie");
        updateRequest.setOmschrijving("Nieuwe Omschrijving");

        when(besprekingRepository.findById(1L)).thenReturn(Optional.of(bestaandeBespreking));

        // Act
        besprekingService.updateBespreking(1L, updateRequest);

        // Assert
        assertEquals("Nieuwe Titel", bestaandeBespreking.getTitelBespreking());
        assertEquals("2024-12-10", bestaandeBespreking.getDatum());
        assertEquals("Nieuwe Locatie", bestaandeBespreking.getLocatie());
        assertEquals("Nieuwe Omschrijving", bestaandeBespreking.getOmschrijving());

        verify(besprekingRepository, times(1)).save(bestaandeBespreking);
    }
}
