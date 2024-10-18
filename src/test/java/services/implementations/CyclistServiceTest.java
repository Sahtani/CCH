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

class CyclistServiceTest {

    @Mock
    private CyclistRepository cyclistRepository;

    @InjectMocks
    private CyclistServiceImpl cyclistService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCyclistWithValidData() {
        // Arrange
        Team team = new Team();
        team.setName("Team A");

        Cyclist cyclist = new Cyclist();
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

}