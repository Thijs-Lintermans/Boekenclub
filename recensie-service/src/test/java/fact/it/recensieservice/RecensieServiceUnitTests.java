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
        recensieRequest.setBoekId("boek456");  // Use the ID directly
        recensieRequest.setLidId("lid123");    // Use the ID directly

        // LidResponse en BoekResponse mocken
        LidResponse lidResponse = new LidResponse("lid123", "Jan", "Jansen", "jan.jansen@example.com");
        BoekResponse boekResponse = new BoekResponse("boek456", "Het avontuur", "Auteur A", "Fictie", null, 300);

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
    void testGetRecensiesByLidId() {
        // Arrange
        String lidId = "123";
        Recensie recensie1 = new Recensie("Great book!", "Loved it!", LocalDateTime.now(), "book123", lidId);
        Recensie recensie2 = new Recensie("Interesting read.", "Very engaging.", LocalDateTime.now(), "book456", lidId);
        List<Recensie> recensies = Arrays.asList(recensie1, recensie2);

        // Mock the repository to return the recensies list
        when(recensieRepository.findByLidId(lidId)).thenReturn(recensies);

        // Create expected RecensieResponse objects
        RecensieResponse expectedResponse1 = new RecensieResponse.Builder()
                .id(1)
                .titelRecensie("Great book!")
                .description("Loved it!")
                .datumTijd(recensie1.getDatumTijd())
                .boek(new BoekResponse("book123", "Book Title", "Author", "Genre", LocalDateTime.now().toLocalDate(), 300))
                .lid(new LidResponse("123", "John", "Doe", "john.doe@example.com"))
                .build();

        RecensieResponse expectedResponse2 = new RecensieResponse.Builder()
                .id(2)
                .titelRecensie("Interesting read.")
                .description("Very engaging.")
                .datumTijd(recensie2.getDatumTijd())
                .boek(new BoekResponse("book456", "Another Book", "Author", "Genre", LocalDateTime.now().toLocalDate(), 250))
                .lid(new LidResponse("123", "John", "Doe", "john.doe@example.com"))
                .build();

        List<RecensieResponse> expectedResponses = Arrays.asList(expectedResponse1, expectedResponse2);

        // Act
        List<RecensieResponse> result = recensieService.getRecensiesByLidId(lidId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(expectedResponses.get(0).getTitelRecensie(), result.get(0).getTitelRecensie());
        assertEquals(expectedResponses.get(1).getTitelRecensie(), result.get(1).getTitelRecensie());
        assertEquals(expectedResponses.get(0).getDescription(), result.get(0).getDescription());
        assertEquals(expectedResponses.get(1).getDescription(), result.get(1).getDescription());
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

