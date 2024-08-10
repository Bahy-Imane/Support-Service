package Support.JUnit.test;

import Support.Service.model.Failure;
import Support.Service.repository.FailureRepository;
import Support.Service.service.FailureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FailureServiceTest {

    @Mock
    private FailureRepository failureRepository;

    @InjectMocks
    private FailureService failureService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllFailures() {
        Failure failure1 = new Failure(1L, "Failure 1", null, null, null);
        Failure failure2 = new Failure(2L, "Failure 2", null, null, null);
        List<Failure> failures = Arrays.asList(failure1, failure2);
        when(failureRepository.findAll()).thenReturn(failures);

        List<Failure> result = failureService.getAllFailures();


        assertEquals(2, result.size());
        assertEquals(failure1, result.get(0));
        assertEquals(failure2, result.get(1));
    }

    @Test
    public void testAddFailure() {

        Failure failure = new Failure(1L, "New Failure", null, null, null);
        when(failureRepository.save(failure)).thenReturn(failure);


        Failure result = failureService.addFailure(failure);


        assertEquals(failure, result);
    }

    @Test
    public void testUpdateFailure() {

        Long failureId = 1L;
        Failure existingFailure = new Failure(failureId, "Old Description", null, null, null);
        Failure updatedFailure = new Failure(null, "New Description", null, null, null);
        when(failureRepository.findById(failureId)).thenReturn(Optional.of(existingFailure));
        when(failureRepository.save(existingFailure)).thenReturn(existingFailure);


        Failure result = failureService.updateFailure(failureId, updatedFailure);


        assertNotNull(result);
        assertEquals("New Description", result.getDescription());
        verify(failureRepository, times(1)).findById(failureId);
        verify(failureRepository, times(1)).save(existingFailure);
    }

    @Test
    public void testDeleteFailure() {

        Long failureId = 1L;


        failureService.deleteFailure(failureId);


        verify(failureRepository, times(1)).deleteById(failureId);
    }
}
