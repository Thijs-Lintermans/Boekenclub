package fact.it.recensieservice;

import fact.it.recensieservice.dto.*;
import fact.it.recensieservice.model.Recensie;
import fact.it.recensieservice.repository.RecensieRepository;
import fact.it.recensieservice.service.BoekService;
import fact.it.recensieservice.service.LidService;
import fact.it.recensieservice.service.RecensieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecensieServiceUnitTests {

    @InjectMocks
    private RecensieService recensieService;

    @Mock
    private RecensieRepository recensieRepository;

    @Mock
    private BoekService boekService;

    @Mock
    private LidService lidService;

    private Recensie recensie;
    private RecensieRequest recensieRequest;
    private RecensieResponse recensieResponse;

    @BeforeEach
    void setUp() {
        // Voorbeelddata voor testen
        recensie = new Recensie("Top boek!", "Een heel interessant boek.", LocalDateTime.now(), "lid123", "boek456");
        recensie.setId(1);

        recensieRequest = new RecensieRequest();
        recensieRequest.setTitelRecensie("Top boek!");
        recensieRequest.setDescription("Een heel interessant boek.");
        recensieRequest.setDatumTijd(LocalDateTime.now());

        // LidResponse en BoekResponse mocken
        LidResponse lidResponse = new LidResponse("lid123", "Jan", "Jansen", "jan.jansen@example.com");
        BoekResponse boekResponse = new BoekResponse("boek456", "Het avontuur", "Auteur A", "Fictie", null, 300);

        // Zet volledige objecten door naar RecensieRequest
        recensieRequest.setLid(lidResponse);   // Gebruik het volledige LidResponse object
        recensieRequest.setBoek(boekResponse); // Gebruik het volledige BoekResponse object

        // Maak een RecensieResponse met volledige objecten
        recensieResponse = new RecensieResponse(1, "Top boek!", "Een heel interessant boek.", LocalDateTime.now(), boekResponse, lidResponse);

        // Mock de LidService en BoekService om de juiste objecten terug te geven
        lenient().when(lidService.getLidById("lid123")).thenReturn(lidResponse);
        lenient().when(boekService.getBoekById("boek456")).thenReturn(boekResponse);
    }

    @Test
    public void testGetAllRecensies() {
        // Arrange
        when(recensieRepository.findAll()).thenReturn(Arrays.asList(recensie));

        // Act
        List<RecensieResponse> result = recensieService.getAllRecensies();

        // Assert
        assertEquals(1, result.size());
        assertEquals("Top boek!", result.get(0).getTitelRecensie());
        verify(recensieRepository, times(1)).findAll();
    }

    @Test
    public void testGetRecensiesByLidId() {
        // Arrange
        String lidId = "lid123";
        when(recensieRepository.findByLidId(lidId)).thenReturn(Arrays.asList(recensie));

        // Act
        List<RecensieResponse> result = recensieService.getRecensiesByLidId(lidId);

        // Assert
        assertEquals(1, result.size());
        assertEquals("lid123", result.get(0).getLid().getId()); // Lid is nu goed geïnitialiseerd
        verify(recensieRepository, times(1)).findByLidId(lidId);
    }

    @Test
    public void testCreateRecensie() {
        // Arrange
        when(recensieRepository.save(any(Recensie.class))).thenReturn(recensie);

        // Act
        RecensieResponse result = recensieService.createRecensie(recensieRequest);

        // Assert
        assertNotNull(result);
        assertEquals("Top boek!", result.getTitelRecensie());
        verify(recensieRepository, times(1)).save(any(Recensie.class));
    }

    @Test
    public void testUpdateRecensie() {
        // Arrange
        String recensieId = "1";  // Correcting type to String
        when(recensieRepository.findById(recensieId)).thenReturn(Optional.of(recensie));
        when(recensieRepository.save(any(Recensie.class))).thenReturn(recensie);

        // Act
        RecensieResponse result = recensieService.updateRecensie(recensieId, recensieRequest);

        // Assert
        assertNotNull(result);
        assertEquals("Top boek!", result.getTitelRecensie());
        verify(recensieRepository, times(1)).save(any(Recensie.class));
    }

    @Test
    public void testDeleteRecensie() {
        String recensieId = "1";  // Correct the ID to String (since your service method expects String)

        // Mock the repository method to return the Recensie if the ID matches
        when(recensieRepository.findById(recensieId)).thenReturn(Optional.of(recensie));  // Return an Optional containing the recensie
        doNothing().when(recensieRepository).deleteById(recensieId);  // Ensure deleteById does nothing when called

        // Act
        recensieService.deleteRecensie(recensieId);  // Call the service method with the String ID

        // Assert
        verify(recensieRepository, times(1)).findById(recensieId);  // Verify findById was called
        verify(recensieRepository, times(1)).deleteById(recensieId);  // Verify deleteById was called
    }




}

