package services.implementations;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.entities.Team;
import com.youcode.mappers.TeamMapper;
import com.youcode.repositories.TeamRepository;
import com.youcode.services.implementations.TeamServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeamServiceImplTest {

    @Mock
    private TeamRepository teamRepository;
    @Mock
    private TeamMapper teamMapper;
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

        TeamResponseDTO result = teamService.save(teamRequest);

        assertNotNull(result);
        assertEquals("Team A", result.name());
        verify(teamRepository).save(any(Team.class));
    }

    @Test
    void testAddTeamWithDuplicateName() {
        TeamRequestDTO teamRequest = new TeamRequestDTO("Team A");
        when(teamRepository.existsByName("Team A")).thenReturn(true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            teamService.save(teamRequest);
        });

        assertEquals("Team with the same name already exists.", exception.getMessage());
        verify(teamRepository, never()).save(any(Team.class));
    }

    @Test
    void testAddTeamWithEmptyName() {
        TeamRequestDTO teamRequest = new TeamRequestDTO("");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            teamService.save(teamRequest);
        });

        assertEquals("Team name cannot be empty.", exception.getMessage());
        verify(teamRepository, never()).save(any(Team.class));
    }

    @Test
    void testAddTeamWhenDatabaseFails() {
        TeamRequestDTO teamRequest = new TeamRequestDTO("Team A");
        when(teamRepository.existsByName("Team A")).thenReturn(false);
        when(teamRepository.save(any(Team.class))).thenThrow(new RuntimeException("Database error"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            teamService.save(teamRequest);
        });

        assertEquals("Database error", exception.getMessage());
        verify(teamRepository, times(1)).save(any(Team.class));
    }

    @Test
    void testUpdateTeam_Success() {
        Long teamId = 1L;
        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("Updated Team Name");

        Team existingTeam = new Team();
        existingTeam.setId(teamId);
        existingTeam.setName("Old Team Name");

        TeamResponseDTO teamResponseDTO = new TeamResponseDTO(teamId, "Updated Team Name");

        when(teamRepository.findById(teamId)).thenReturn(Optional.of(existingTeam));
        when(teamMapper.toDto(existingTeam)).thenReturn(teamResponseDTO);

        TeamResponseDTO result = teamService.update(teamId, teamRequestDTO);

        assertNotNull(result);
        assertEquals(teamId, result.id());
        assertEquals("Updated Team Name", result.name());

        verify(teamRepository).findById(teamId);
        verify(teamMapper).toDto(existingTeam);
    }

    @Test
    void testUpdateTeam_TeamNotFound() {

        Long teamId = 1L;
        TeamRequestDTO teamRequestDTO = new TeamRequestDTO("Updated Team Name");

        when(teamRepository.findById(teamId)).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> teamService.update(teamId, teamRequestDTO));

        assertEquals("Team with ID " + teamId + " not found.", exception.getMessage());
        verify(teamRepository).findById(teamId);
        verify(teamMapper, never()).toDto(any(Team.class));
    }
}
