import com.youcode.entities.Competition;
import com.youcode.entities.Cyclist;
import com.youcode.repositories.CompetitionRepository;
import com.youcode.repositories.CyclistRepository;
import com.youcode.repositories.GeneralResultRepository;
import com.youcode.services.implementations.CompetitionServiceImpl;
import com.youcode.services.implementations.GeneralResultServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GeneralResultServiceImplTest {
    @InjectMocks
    private CompetitionServiceImpl competitionService;

    @Mock
    private CompetitionRepository competitionRepository;

    @Mock
    private CyclistRepository cyclistRepository;

    @Mock
    private GeneralResultRepository generalResultRepository;
@InjectMocks
GeneralResultServiceImpl generalResultService;
    private Competition competition;
    private Cyclist cyclist;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a sample Competition and Cyclist
        competition = new Competition();
        competition.setId(1L); // Assuming IDs are Long
        competition.setName("Tour de France");

        cyclist = new Cyclist();
        cyclist.setId(1L); // Assuming IDs are Long
        cyclist.setName("John Doe");
    }
//
//    @Test
//    public void testSave_ShouldCreateGeneralResult() {
//        // Mocking the repositories' behavior
//        when(competitionRepository.findById(1L)).thenReturn(Optional.of(competition));
//        when(cyclistRepository.findById(1L)).thenReturn(Optional.of(cyclist));
//        when(generalResultRepository.save(any(GeneralResult.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        // Call the save method
//        GeneralResult result = generalResultService.save(1L, 1L);
//
//        // Verify interactions and results
//        assertNotNull(result);
//        assertEquals(cyclist, result.getCyclist());
//        assertEquals(competition, result.getCompetition());
//        verify(generalResultRepository).save(any(GeneralResult.class));
//    }
}
