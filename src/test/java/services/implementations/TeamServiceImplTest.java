package services.implementations;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.entities.Team;
import com.youcode.repositories.TeamRepository;
import com.youcode.services.implementations.TeamServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeamServiceImplTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamServiceImpl teamService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddTeamSuccessfully() {
        // Arrange
        TeamRequestDTO teamRequest = new TeamRequestDTO("Team A");
        Team teamEntity = new Team();
        teamEntity.setName("Team A");

        when(teamRepository.existsByName("Team A")).thenReturn(false);
        when(teamRepository.save(any(Team.class))).thenReturn(teamEntity);

        // Act
        TeamResponseDTO result = teamService.save(teamRequest);

        // Assert
        assertNotNull(result);
        assertEquals("Team A", result.getClass().getName());
        verify(teamRepository).save(any(Team.class));
    }

    @Test
    public void testAddTeamWithDuplicateName() {

        Team team = new Team();
        team.setName("Team A");
        when(teamRepository.existsByName("Team A")).thenReturn(true);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            teamService.save(team);
        });

        assertEquals("Team with the same name already exists.", exception.getMessage());
        verify(teamRepository, never()).save(any(Team.class));
    }

    @Test
    public void testAddTeamWithEmptyName() {

        Team team = new Team();
        team.setName("");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            teamService.save(team);
        });

        assertEquals("Team name cannot be empty.", exception.getMessage());
        verify(teamRepository, never()).save(any(Team.class));
    }

    @Test
    public void testAddTeamWhenDatabaseFails() {

        Team team = new Team();
        team.setName("Team A");
        when(teamRepository.save(any(Team.class))).thenThrow(new RuntimeException("Database error"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            teamService.save(team);
        });

        assertEquals("Database error", exception.getMessage());
        verify(teamRepository, times(1)).save(team);
    }
}
