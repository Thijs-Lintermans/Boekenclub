package fact.it.lidservice;

import fact.it.lidservice.dto.LidRequest;
import fact.it.lidservice.dto.LidResponse;
import fact.it.lidservice.model.Lid;
import fact.it.lidservice.repository.LidRepository;
import fact.it.lidservice.service.LidService;
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
public class LidServiceUnitTests {

    @InjectMocks
    private LidService lidService;

    @Mock
    private LidRepository lidRepository;

    @Test
    public void testCreateLid() {
        // Arrange
        LidRequest lidRequest = new LidRequest();
        lidRequest.setVoornaam("Jan");
        lidRequest.setAchternaam("Jansen");
        lidRequest.setEmail("jan.jansen@example.com");

        // Act
        lidService.createLid(lidRequest);

        // Assert
        verify(lidRepository, times(1)).save(any(Lid.class));
    }

    @Test
    public void testGetAllLids() {
        // Arrange
        Lid lid = new Lid();
        lid.setId("1");
        lid.setVoornaam("Jan");
        lid.setAchternaam("Jansen");
        lid.setEmail("jan.jansen@example.com");

        when(lidRepository.findAll()).thenReturn(Arrays.asList(lid));

        // Act
        List<LidResponse> leden = lidService.getAllLids();

        // Assert
        assertEquals(1, leden.size());
        assertEquals("Jan", leden.get(0).getVoornaam());
        assertEquals("Jansen", leden.get(0).getAchternaam());
        assertEquals("jan.jansen@example.com", leden.get(0).getEmail());

        verify(lidRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllLedenByEmail() {
        // Arrange
        Lid lid = new Lid();
        lid.setId("1");
        lid.setVoornaam("Jan");
        lid.setAchternaam("Jansen");
        lid.setEmail("jan.jansen@example.com");

        when(lidRepository.findByEmail(Arrays.asList("jan.jansen@example.com"))).thenReturn(Arrays.asList(lid));

        // Act
        List<LidResponse> leden = lidService.getAllLedenByEmail(Arrays.asList("jan.jansen@example.com"));

        // Assert
        assertEquals(1, leden.size());
        assertEquals("jan.jansen@example.com", leden.get(0).getEmail());

        verify(lidRepository, times(1)).findByEmail(Arrays.asList("jan.jansen@example.com"));
    }

    @Test
    public void testGetLidById() {
        // Arrange
        Lid lid = new Lid();
        lid.setId("1");
        lid.setVoornaam("Jan");
        lid.setAchternaam("Jansen");
        lid.setEmail("jan.jansen@example.com");

        when(lidRepository.findById("1")).thenReturn(Optional.of(lid));

        // Act
        LidResponse lidResponse = lidService.getLidById("1");

        // Assert
        assertNotNull(lidResponse);
        assertEquals("1", lidResponse.getId());
        assertEquals("Jan", lidResponse.getVoornaam());
        assertEquals("Jansen", lidResponse.getAchternaam());
        assertEquals("jan.jansen@example.com", lidResponse.getEmail());

        verify(lidRepository, times(1)).findById("1");
    }

    @Test
    public void testUpdateLid() {
        // Arrange
        Lid existingLid = new Lid();
        existingLid.setId("1");
        existingLid.setVoornaam("Oud");
        existingLid.setAchternaam("Naam");
        existingLid.setEmail("oud.naam@example.com");

        LidRequest lidRequest = new LidRequest();
        lidRequest.setVoornaam("Nieuw");
        lidRequest.setAchternaam("Naam");
        lidRequest.setEmail("nieuw.naam@example.com");

        when(lidRepository.findById("1")).thenReturn(Optional.of(existingLid));

        // Act
        lidService.updateLid("1", lidRequest);

        // Assert
        assertEquals("Nieuw", existingLid.getVoornaam());
        assertEquals("Naam", existingLid.getAchternaam());
        assertEquals("nieuw.naam@example.com", existingLid.getEmail());

        verify(lidRepository, times(1)).save(existingLid);
    }

    @Test
    public void testDeleteLid() {
        // Arrange
        when(lidRepository.existsById("1")).thenReturn(true);

        // Act
        lidService.deleteLid("1");

        // Assert
        verify(lidRepository, times(1)).deleteById("1");
    }
}
