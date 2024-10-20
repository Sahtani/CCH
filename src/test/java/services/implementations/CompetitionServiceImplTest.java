package services.implementations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.youcode.dtos.response.CompetitionResponseDto;
import com.youcode.entities.Competition;
import com.youcode.entities.Cyclist;
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

        // Initialize the Competition object
        competition = new Competition();
        competition.setId(1L);
        competition.setName("Tour de France"); // Set additional attributes as needed
        competition.setLocation("France");
        competition.setStartDate(LocalDate.of(2024, 7, 1));
        competition.setEndDate(LocalDate.of(2024, 7, 30));

        // If you have a Cyclist in Competition, you may want to add that as well
        Cyclist cyclist = new Cyclist();
        cyclist.setId(1L);
        cyclist.setFirstName("Soumia");
        cyclist.setLastName("Sahtani");
        cyclist.setAge(25);
        cyclist.setNationality("Morocco");

        // Assuming you have a method to add cyclists to competition
        competition.addCyclist(cyclist); // Replace with the actual method to associate cyclists if needed
    }

    @Test
    public void testUpdate_CompetitionExists() {
        // Arrange
        when(competitionRepository.existsById(competition.getId())).thenReturn(true);
        when(competitionRepository.save(competition)).thenReturn(competition);

        // Act
        CompetitionResponseDto updatedCompetition = competitionService.update(competition);

        // Assert
        assertNotNull(updatedCompetition);
        assertEquals(competition.getId(), updatedCompetition.id());
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
