package services.implementations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.youcode.dtos.request.CyclistRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
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

    private Team team;
    private CyclistRequestDTO cyclistRequestDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        team = new Team();
        team.setName("Team A");

        cyclistRequestDTO = new CyclistRequestDTO(
                "Soumia sahtani",
                25,
                "Morocco",
                1L
        );
    }

    @Test
    void testSaveCyclistWithValidData() {
        Cyclist cyclist = new Cyclist();
        cyclist.setId(1L);
        cyclist.setName(cyclistRequestDTO.name());
        cyclist.setAge(cyclistRequestDTO.age());
        cyclist.setNationality(cyclistRequestDTO.nationality());
        cyclist.setTeam(team);

        when(cyclistRepository.existsByName(cyclist.getName())).thenReturn(false);
        when(cyclistRepository.save(cyclist)).thenReturn(cyclist);

        CyclistResponseDTO savedCyclist = cyclistService.save(cyclistRequestDTO);
        assertNotNull(savedCyclist);
        assertEquals("Soumia sahtani", savedCyclist.name());
        assertEquals(25, savedCyclist.age());
        verify(cyclistRepository, times(1)).save(cyclist);
    }

    @Test
    void testUpdateCyclistWithValidData() {
        cyclistRequestDTO = new CyclistRequestDTO(
                "Soumia sahtani",
                25,
                "Morocco",
                1L // teamId
        );

        when(cyclistRepository.existsById(cyclistRequestDTO.id())).thenReturn(true);
        when(cyclistRepository.save(any(Cyclist.class))).thenAnswer(invocation -> invocation.getArgument(0));

        CyclistResponseDTO updatedCyclist = cyclistService.update(cyclistRequestDTO);
        assertNotNull(updatedCyclist);
        assertEquals("Soumia", updatedCyclist.firstName());
        assertEquals(25, updatedCyclist.age());
        verify(cyclistRepository, times(1)).save(any(Cyclist.class));
    }

    @Test
    void testDeleteCyclist() {
        long cyclistId = 1L;
        when(cyclistRepository.existsById(cyclistId)).thenReturn(true);
        cyclistService.delete(cyclistId);
        verify(cyclistRepository, times(1)).deleteById(cyclistId);
    }

    @Test
    void testGetAllCyclists() {
        List<Cyclist> cyclists = new ArrayList<>();
        Cyclist cyclist = new Cyclist();
        cyclist.setFirstName("Soumia");
        cyclist.setLastName("Sahtani");
        cyclist.setAge(25);
        cyclist.setNationality("Morocco");
        cyclists.add(cyclist);

        when(cyclistRepository.findAll()).thenReturn(cyclists);
        List<CyclistResponseDTO> result = cyclistService.getAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Soumia", result.get(0).firstName());
        verify(cyclistRepository, times(1)).findAll();
    }
}
