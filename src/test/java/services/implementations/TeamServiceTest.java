package services.implementations;

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

class TeamServiceTest {

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
        Team team = new Team();
        team.setName("Team A");

        when(teamRepository.existsByName("Team A")).thenReturn(false);
        when(teamRepository.save(team)).thenReturn(team);

        Team result = teamService.save(team);

        assertNotNull(result);
        assertEquals("Team A", result.getName());
        verify(teamRepository).save(team);
    }
    @Test
    public void testAddTeamWithDuplicateName() {
        // Scénario 2 : Équipe avec un nom déjà existant
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
        // Scénario 3 : Nom vide ou null
        Team team = new Team();
        team.setName("");  // ou `null`

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            teamService.save(team);
        });

        assertEquals("Team name cannot be empty.", exception.getMessage());
        verify(teamRepository, never()).save(any(Team.class));
    }

    @Test
    public void testAddTeamWhenDatabaseFails() {
        // Scénario 4 : Erreur de sauvegarde (ex. : DB non disponible)
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
