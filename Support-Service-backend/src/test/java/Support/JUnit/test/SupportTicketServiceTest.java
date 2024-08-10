package Support.JUnit.test;

import Support.Service.dto.SupportTicketDto;
import Support.Service.enums.TicketStatus;
import Support.Service.model.*;
import Support.Service.repository.EquipmentRepository;
import Support.Service.repository.FailureRepository;
import Support.Service.repository.PersonRepository;
import Support.Service.repository.SupportTicketRepository;
import Support.Service.service.SupportTicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SupportTicketServiceTest {

    @Mock
    private SupportTicketRepository supportTicketRepository;

    @Mock
    private FailureRepository failureRepository;

    @Mock
    private EquipmentRepository equipmentRepository;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private SupportTicketService supportTicketService;

    private User user;
    private SupportTicketDto supportTicketDto;
    private SupportTicket supportTicket;
    private Equipment equipment;
    private Failure failure;
    private Technician technician;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setPersonId(1L);

        equipment = new Equipment();
        equipment.setEquipmentId(1L);

        failure = new Failure();
        failure.setFailureId(1L);

        technician = new Technician();
        technician.setPersonId(2L);

        supportTicketDto = new SupportTicketDto();
        supportTicketDto.setSubject("Test Ticket");
        supportTicketDto.setEquipmentId(1L);
        supportTicketDto.setFailureId(1L);

        supportTicket = new SupportTicket();
        supportTicket.setTickettId(1L);
        supportTicket.setSubject("Test Ticket");
        supportTicket.setCreatedAt(LocalDateTime.now());
        supportTicket.setTicketStatus(TicketStatus.REPORTED);
        supportTicket.setUser(user);
        supportTicket.setEquipment(equipment);
        supportTicket.setFailure(failure);
    }

    @Test
    void createTicket_Success() {
        when(equipmentRepository.findById(supportTicketDto.getEquipmentId())).thenReturn(Optional.of(equipment));
        when(failureRepository.findById(supportTicketDto.getFailureId())).thenReturn(Optional.of(failure));
        when(supportTicketRepository.save(any(SupportTicket.class))).thenReturn(supportTicket);

        SupportTicket createdTicket = supportTicketService.createTicket(user, supportTicketDto);

        assertNotNull(createdTicket);
        assertEquals("Test Ticket", createdTicket.getSubject());
        assertEquals(user, createdTicket.getUser());
        verify(supportTicketRepository, times(1)).save(any(SupportTicket.class));
    }

    @Test
    void assignTicketToTechnician_Success() {
        when(supportTicketRepository.findById(1L)).thenReturn(Optional.of(supportTicket));
        when(personRepository.findById(technician.getPersonId())).thenReturn(Optional.of(technician));
        when(supportTicketRepository.save(any(SupportTicket.class))).thenReturn(supportTicket);

        SupportTicket assignedTicket = supportTicketService.assignTicketToTechnician(1L, 2L);

        assertNotNull(assignedTicket);
        assertEquals(technician, assignedTicket.getTechnician());
        assertEquals(TicketStatus.ASSIGNED, assignedTicket.getTicketStatus());
        verify(supportTicketRepository, times(1)).save(any(SupportTicket.class));
    }

    @Test
    void findTicketById_Success() {
        when(supportTicketRepository.findById(1L)).thenReturn(Optional.of(supportTicket));

        SupportTicket foundTicket = supportTicketService.findTicketById(1L);

        assertNotNull(foundTicket);
        assertEquals(1L, foundTicket.getTickettId());
        verify(supportTicketRepository, times(1)).findById(1L);
    }

    @Test
    void updateTicketStatus_Success() {
        when(supportTicketRepository.findById(1L)).thenReturn(Optional.of(supportTicket));
        when(supportTicketRepository.save(any(SupportTicket.class))).thenReturn(supportTicket);

        SupportTicket updatedTicket = supportTicketService.updateTicketStatus(supportTicket, 1L);

        assertNotNull(updatedTicket);
        assertEquals(supportTicket.getTicketStatus(), updatedTicket.getTicketStatus());
        verify(supportTicketRepository, times(1)).save(any(SupportTicket.class));
    }

    @Test
    void updateTicket_Success() {
        when(supportTicketRepository.findById(1L)).thenReturn(Optional.of(supportTicket));
        when(supportTicketRepository.save(any(SupportTicket.class))).thenReturn(supportTicket);

        SupportTicket updatedTicket = supportTicketService.updateTicket(1L, TicketStatus.CLOSED);

        assertNotNull(updatedTicket);
        assertEquals(TicketStatus.CLOSED, updatedTicket.getTicketStatus());
        verify(supportTicketRepository, times(1)).save(any(SupportTicket.class));
    }

    @Test
    void findTicketsByUser_Success() {
        when(supportTicketRepository.findSupportTicketByUserPersonId(user.getPersonId())).thenReturn(Arrays.asList(supportTicket));

        List<SupportTicket> tickets = supportTicketService.findTicketsByUser(user.getPersonId());

        assertNotNull(tickets);
        assertFalse(tickets.isEmpty());
        assertEquals(1, tickets.size());
        assertEquals(user, tickets.get(0).getUser());
        verify(supportTicketRepository, times(1)).findSupportTicketByUserPersonId(user.getPersonId());
    }
}
