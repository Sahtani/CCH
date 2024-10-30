package services.implementations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.entities.Team;
import com.youcode.mappers.TeamMapper;
import com.youcode.repositories.TeamRepository;
import com.youcode.services.api.TeamService;
import com.youcode.services.implementations.TeamServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private TeamMapper teamMapper;

    @InjectMocks
    private TeamServiceImpl  teamService;

    private TeamRequestDTO validDto;

    @BeforeEach
    public void setUp() {
        validDto = new TeamRequestDTO("Valid Team Name");
    }

    @Test
    public void save_ValidTeam_ShouldSaveAndReturnDto() {
        // Arrange
        Team teamToSave = new Team();
        teamToSave.setName(validDto.name());

        Team savedTeam = new Team();
        savedTeam.setId(1L);
        savedTeam.setName(validDto.name());

        TeamResponseDTO expectedResponse =teamMapper.toDto(teamToSave);

        when(teamRepository.existsByName(validDto.name())).thenReturn(false);
        when(teamMapper.toDto(savedTeam)).thenReturn(expectedResponse);
        when(teamRepository.save(any(Team.class))).thenReturn(savedTeam);

        // Act
        TeamResponseDTO result = teamService.save(validDto);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResponse.id(), result.id());
        assertEquals(expectedResponse.name(), result.name());

        // Verify interactions
        verify(teamRepository).existsByName(validDto.name());
        verify(teamRepository).save(any(Team.class));
        verify(teamMapper).toDto(savedTeam);
    }



    @Test
    public void save_TeamNameAlreadyExists_ShouldThrowException() {
        // Arrange
        when(teamRepository.existsByName(validDto.name())).thenReturn(true);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            teamService.save(validDto);
        });

        assertEquals("Team with the same name already exists.", exception.getMessage());
    }
}
