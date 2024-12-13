package fact.it.boekservice;

import fact.it.boekservice.dto.BoekRequest;
import fact.it.boekservice.dto.BoekResponse;
import fact.it.boekservice.model.Boek;
import fact.it.boekservice.repository.BoekRepository;
import fact.it.boekservice.service.BoekService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoekServiceUnitTests {

    @InjectMocks
    private BoekService boekService;

    @Mock
    private BoekRepository boekRepository;

    @Test
    public void testCreateBoek() {
        // Arrange
        BoekRequest boekRequest = new BoekRequest();
        boekRequest.setTitel("Test Titel");
        boekRequest.setAuteur("Test Auteur");
        boekRequest.setGenre("Test Genre");
        boekRequest.setPublicatieDatum(LocalDate.now());
        boekRequest.setAantalPaginas(300);

        // Act
        boekService.createBoek(boekRequest);

        // Assert
        verify(boekRepository, times(1)).save(any(Boek.class));
    }

    @Test
    public void testGetAllBoeken() {
        // Arrange
        Boek boek = new Boek();
        boek.setId("1");
        boek.setTitel("Test Titel");
        boek.setAuteur("Test Auteur");
        boek.setGenre("Test Genre");
        boek.setPublicatieDatum(LocalDate.now());
        boek.setAantalPaginas(300);

        when(boekRepository.findAll()).thenReturn(Arrays.asList(boek));

        // Act
        List<BoekResponse> boeken = boekService.getAllBoeken();

        // Assert
        assertEquals(1, boeken.size());
        assertEquals("Test Titel", boeken.get(0).getTitel());
        assertEquals("Test Auteur", boeken.get(0).getAuteur());
        assertEquals("Test Genre", boeken.get(0).getGenre());
        assertEquals(300, boeken.get(0).getAantalPaginas());

        verify(boekRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllBoekenByTitel() {
        // Arrange
        Boek boek = new Boek();
        boek.setId("1");
        boek.setTitel("Test Titel");
        boek.setAuteur("Test Auteur");
        boek.setGenre("Test Genre");
        boek.setPublicatieDatum(LocalDate.now());
        boek.setAantalPaginas(300);

        when(boekRepository.findByTitel(Arrays.asList("Test Titel"))).thenReturn(Arrays.asList(boek));

        // Act
        List<BoekResponse> boeken = boekService.getAllBoekenByTitel(Arrays.asList("Test Titel"));

        // Assert
        assertEquals(1, boeken.size());
        assertEquals("Test Titel", boeken.get(0).getTitel());

        verify(boekRepository, times(1)).findByTitel(Arrays.asList("Test Titel"));
    }

    @Test
    public void testUpdateBoek() {
        // Arrange
        Boek existingBoek = new Boek();
        existingBoek.setId("1");
        existingBoek.setTitel("Oude Titel");
        existingBoek.setAuteur("Oude Auteur");
        existingBoek.setGenre("Oud Genre");
        existingBoek.setPublicatieDatum(LocalDate.now());
        existingBoek.setAantalPaginas(300);

        BoekRequest boekRequest = new BoekRequest();
        boekRequest.setTitel("Nieuwe Titel");
        boekRequest.setAuteur("Nieuwe Auteur");
        boekRequest.setGenre("Nieuw Genre");
        boekRequest.setPublicatieDatum(LocalDate.now());
        boekRequest.setAantalPaginas(400);

        when(boekRepository.findById("1")).thenReturn(Optional.of(existingBoek));

        // Act
        boekService.updateBoek("1", boekRequest);

        // Assert
        assertEquals("Nieuwe Titel", existingBoek.getTitel());
        assertEquals("Nieuwe Auteur", existingBoek.getAuteur());
        assertEquals("Nieuw Genre", existingBoek.getGenre());
        assertEquals(400, existingBoek.getAantalPaginas());

        verify(boekRepository, times(1)).save(existingBoek);
    }

    @Test
    public void testGetBoekById() {
        // Arrange
        Boek boek = new Boek();
        boek.setId("1");
        boek.setTitel("Test Titel");
        boek.setAuteur("Test Auteur");
        boek.setGenre("Test Genre");
        boek.setPublicatieDatum(LocalDate.now());
        boek.setAantalPaginas(300);

        when(boekRepository.findById("1")).thenReturn(Optional.of(boek));

        // Act
        BoekResponse boekResponse = boekService.getBoekById("1");

        // Assert
        assertNotNull(boekResponse);
        assertEquals("1", boekResponse.getId());
        assertEquals("Test Titel", boekResponse.getTitel());
        assertEquals("Test Auteur", boekResponse.getAuteur());
        assertEquals("Test Genre", boekResponse.getGenre());

        verify(boekRepository, times(1)).findById("1");
    }

    @Test
    public void testDeleteBoek() {
        // Arrange
        when(boekRepository.existsById("1")).thenReturn(true);

        // Act
        boekService.deleteBoek("1");

        // Assert
        verify(boekRepository, times(1)).deleteById("1");
    }
}
