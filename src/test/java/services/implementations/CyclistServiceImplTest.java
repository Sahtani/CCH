package services.implementations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.youcode.entities.Cyclist;
import com.youcode.entities.Team;
import com.youcode.repositories.CyclistRepository;
import com.youcode.services.implementations.CyclistServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class CyclistServiceImplTest {

    @Mock
    private CyclistRepository cyclistRepository;

    @InjectMocks
    private CyclistServiceImpl cyclistService;
    private Cyclist cyclist;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cyclist = new Cyclist();
        cyclist.setId(1L);
        cyclist.setFirstName("Soumia");
        cyclist.setLastName("Sahtani");
        cyclist.setAge(25);
        cyclist.setNationality("Morocco");
    }

    @Test
    void testSaveCyclistWithValidData() {

        Team team = new Team();
        team.setName("Team A");


        cyclist.setFirstName("Soumia");
        cyclist.setLastName("Sahtani");
        cyclist.setAge(25);
        cyclist.setNationality("Morocco");
        cyclist.setTeam(team);

        when(cyclistRepository.existsByName(cyclist.getFirstName() + " " + cyclist.getLastName())).thenReturn(false);
        when(cyclistRepository.save(cyclist)).thenReturn(cyclist);

        Cyclist savedCyclist = cyclistService.save(cyclist);

        assertNotNull(savedCyclist);
        assertEquals("Soumia", savedCyclist.getFirstName());
        assertEquals("Sahtani", savedCyclist.getLastName());
        assertEquals(25, savedCyclist.getAge());
        assertEquals("Team A", savedCyclist.getTeam().getName());
        verify(cyclistRepository, times(1)).save(cyclist);
    }

    @Test
    void testUpdateCyclistWithValidData() {

        when(cyclistRepository.existsById(cyclist.getId())).thenReturn(true);
        when(cyclistRepository.save(cyclist)).thenReturn(cyclist);

        // Act
        Cyclist updatedCyclist = cyclistService.update(cyclist);

        // Assert
        assertNotNull(updatedCyclist);
        assertEquals("Soumia", updatedCyclist.getFirstName());
        assertEquals(25, updatedCyclist.getAge());
        verify(cyclistRepository, times(1)).save(cyclist);
    }
    @Test
    void testDeleteCyclist() {
        // Arrange
        long cyclistId = 1L;
        when(cyclistRepository.existsById(cyclistId)).thenReturn(true);

        // Act
        cyclistService.delete(cyclistId);

        // Assert
        verify(cyclistRepository, times(1)).deleteById(cyclistId);
    }

    @Test
    void testGetAllCyclists() {
        // Arrange
        List<Cyclist> cyclists = new ArrayList<>();
        cyclists.add(cyclist);
        when(cyclistRepository.findAll()).thenReturn(cyclists);

        // Act
        List<Cyclist> result = cyclistService.getAll();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Soumia", result.get(0).getFirstName());
        verify(cyclistRepository, times(1)).findAll();
    }


}