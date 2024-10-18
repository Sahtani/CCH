package services.implementations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.youcode.entities.Competition;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.services.implementations.CompetitionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CompetitionServiceImplTest {

    @InjectMocks
    private CompetitionServiceImpl competitionService;

    @Mock
    private CompetitionRepository competitionRepository;

    private Competition competition;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        competition = new Competition();
        competition.setId(1L);
    }

    @Test
    public void testUpdate_CompetitionExists() {
        // Arrange
        when(competitionRepository.existsById(competition.getId())).thenReturn(true);
        when(competitionRepository.save(competition)).thenReturn(competition);

        // Act
        Competition updatedCompetition = competitionService.update(competition);

        // Assert
        assertNotNull(updatedCompetition);
        assertEquals(competition.getId(), updatedCompetition.getId());
        verify(competitionRepository).save(competition);
    }

    @Test
    public void testUpdate_CompetitionDoesNotExist() {
        // Arrange
        when(competitionRepository.existsById(competition.getId())).thenReturn(false);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            competitionService.update(competition);
        });
        assertEquals("Competition not found.", exception.getMessage());
        verify(competitionRepository, never()).save(any());
    }
}
