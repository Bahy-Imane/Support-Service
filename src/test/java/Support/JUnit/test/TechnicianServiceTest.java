package Support.JUnit.test;

import Support.Service.dto.PersonDto;
import Support.Service.enums.Role;
import Support.Service.model.Technician;
import Support.Service.repository.TechnicianRepository;
import Support.Service.service.TechnicianService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TechnicianServiceTest {

    @Mock
    private TechnicianRepository technicianRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private TechnicianService technicianService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTechnicians() {
        Technician technician = new Technician();
        technician.setUserName("testTechnician");
        technician.setEmail("test@example.com");

        when(technicianRepository.findAll()).thenReturn(List.of(technician));

        List<Technician> technicians = technicianService.getAllTechnicians();
        assertNotNull(technicians);
        assertEquals(1, technicians.size());
        assertEquals("testTechnician", technicians.get(0).getUsername());
    }

    @Test
    public void testGetTechnicianById() {
        Technician technician = new Technician();
        technician.setUserName("testTechnician");
        technician.setEmail("test@example.com");

        when(technicianRepository.findById(1L)).thenReturn(Optional.of(technician));

        Technician foundTechnician = technicianService.getTechnicianById(1L);
        assertNotNull(foundTechnician);
        assertEquals("testTechnician", foundTechnician.getUsername());
    }

    @Test
    public void testAddTechnician() {
        PersonDto personDto = new PersonDto();
        personDto.setUserName("testTechnician");
        personDto.setEmail("test@example.com");
        personDto.setPassword("password");

        Technician technician = new Technician();
        technician.setUserName("testTechnician");
        technician.setEmail("test@example.com");
        technician.setPassword("encodedPassword");
        technician.setRole(Role.TECHNICIAN);

        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
        when(technicianRepository.save(any(Technician.class))).thenReturn(technician);

        Technician savedTechnician = technicianService.addTechnician(personDto);
        assertNotNull(savedTechnician);
        assertEquals("testTechnician", savedTechnician.getUsername());
        verify(technicianRepository).save(any(Technician.class));
    }

    @Test
    public void testDeleteTechnicianById() {
        technicianService.deleteTechnicianById(1L);
        verify(technicianRepository).deleteById(1L);
    }

    @Test
    public void testUpdateTechnician() {
        Technician existingTechnician = new Technician();
        existingTechnician.setUserName("oldTechnician");
        existingTechnician.setEmail("old@example.com");

        Technician updatedTechnician = new Technician();
        updatedTechnician.setUserName("newTechnician");
        updatedTechnician.setEmail("new@example.com");

        when(technicianRepository.findById(1L)).thenReturn(Optional.of(existingTechnician));
        when(technicianRepository.save(any(Technician.class))).thenReturn(updatedTechnician);

        Technician result = technicianService.updateTechnician(1L, updatedTechnician);
        assertNotNull(result);
        assertEquals("newTechnician", result.getUsername());
        verify(technicianRepository).save(argThat(technician ->
                "newTechnician".equals(technician.getUsername()) &&
                        "new@example.com".equals(technician.getEmail())
        ));
    }
}

