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
        teamEntity.setId(1L);
        teamEntity.setName("Team A");

        when(teamRepository.existsByName("Team A")).thenReturn(false);
        when(teamRepository.save(any(Team.class))).thenReturn(teamEntity);

        // Act
        TeamResponseDTO result = teamService.save(teamRequest);

        // Assert
        assertNotNull(result);
        assertEquals("Team A", result.name());
        verify(teamRepository).save(any(Team.class));
    }

    @Test
    void testAddTeamWithDuplicateName() {
        // Arrange
        TeamRequestDTO teamRequest = new TeamRequestDTO("Team A");
        when(teamRepository.existsByName("Team A")).thenReturn(true);

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            teamService.save(teamRequest);
        });

        assertEquals("Team with the same name already exists.", exception.getMessage());
        verify(teamRepository, never()).save(any(Team.class));
    }

    @Test
    void testAddTeamWithEmptyName() {
        // Arrange
        TeamRequestDTO teamRequest = new TeamRequestDTO("");

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            teamService.save(teamRequest);
        });

        assertEquals("Team name cannot be empty.", exception.getMessage());
        verify(teamRepository, never()).save(any(Team.class));
    }

    @Test
    void testAddTeamWhenDatabaseFails() {
        // Arrange
        TeamRequestDTO teamRequest = new TeamRequestDTO("Team A");
        when(teamRepository.existsByName("Team A")).thenReturn(false);
        when(teamRepository.save(any(Team.class))).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            teamService.save(teamRequest);
        });

        assertEquals("Database error", exception.getMessage());
        verify(teamRepository, times(1)).save(any(Team.class));
    }
}
