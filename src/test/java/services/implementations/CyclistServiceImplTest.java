package services.implementations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.youcode.dtos.request.CyclistRequestDTO;
import com.youcode.dtos.response.CyclistResponseDTO;
import com.youcode.entities.Cyclist;
import com.youcode.entities.Team;
import com.youcode.mappers.CyclistMapper;
import com.youcode.repositories.CyclistRepository;
import com.youcode.services.implementations.CyclistServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CyclistServiceImplTest {
    @Mock
    private CyclistRepository cyclistRepository;

    @Mock
    private CyclistMapper cyclistMapper;

    @InjectMocks
    private CyclistServiceImpl cyclistService;

    private CyclistRequestDTO cyclistRequestDTO;
    private Cyclist cyclistEntity;
    private CyclistResponseDTO cyclistResponseDTO;
    private List<Cyclist> cyclists;
    private Team team;

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
        cyclistRequestDTO = new CyclistRequestDTO(
                "Soumia Sahtani", 25, "Morocco", 1L
        );


    }

//    @Test
//    void testSaveCyclistWithValidData() {
//        Cyclist cyclist = new Cyclist();
//        cyclist.setId(1L);
//        cyclist.setName(cyclistRequestDTO.name());
//        cyclist.setAge(cyclistRequestDTO.age());
//        cyclist.setNationality(cyclistRequestDTO.nationality());
//        cyclist.setTeam(team);
//
//        when(cyclistRepository.existsByName(cyclist.getName())).thenReturn(false);
//        when(cyclistRepository.save(cyclist)).thenReturn(cyclist);
//
//        CyclistResponseDTO savedCyclist = cyclistService.save(cyclistRequestDTO);
//        assertNotNull(savedCyclist);
//        assertEquals("Soumia sahtani", savedCyclist.name());
//        assertEquals(25, savedCyclist.age());
//        verify(cyclistRepository, times(1)).save(cyclist);
//    }

//    @Test
//    void testUpdateCyclist() {
//        when(cyclistMapper.toEntity(cyclistRequestDTO)).thenReturn(cyclistEntity);
//        when(cyclistRepository.save(cyclistEntity)).thenReturn(cyclistEntity);
//        when(cyclistMapper.toResponseDTO(cyclistEntity)).thenReturn(cyclistResponseDTO);
//
//        CyclistResponseDTO result = cyclistService.update(cyclistRequestDTO);
//
//        assertNotNull(result);
//        assertEquals("Soumia Sahtani", result.name());
//        assertEquals(25, result.age());
//        assertEquals("Morocco", result.nationality());
//
//        verify(cyclistMapper, times(1)).toEntity(cyclistRequestDTO);
//        verify(cyclistRepository, times(1)).save(cyclistEntity);
//        verify(cyclistMapper, times(1)).toResponseDTO(cyclistEntity);
//    }

    @Test
    void testDeleteCyclist() {
        long cyclistId = 1L;
        when(cyclistRepository.existsById(cyclistId)).thenReturn(true);
        cyclistService.delete(cyclistId);
        verify(cyclistRepository, times(1)).deleteById(cyclistId);
    }

//    @Test
//    void testGetAllCyclists() {
//        List<Cyclist> cyclists = new ArrayList<>();
//        Cyclist cyclist = new Cyclist();
//        cyclist.setName("Soumia sahtani");
//        cyclist.setAge(25);
//        cyclist.setNationality("Morocco");
//        cyclists.add(cyclist);
//
//        when(cyclistRepository.findAll()).thenReturn(cyclists);
//        List<CyclistResponseDTO> result = cyclistService.getAll();
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("Soumia sahtani", result.get(0).name());
//        verify(cyclistRepository, times(1)).findAll();
//    }
}
