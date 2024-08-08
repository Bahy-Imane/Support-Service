package Support.Service.service;

import Support.Service.dto.SupportTicketDto;
import Support.Service.enums.TicketStatus;
import Support.Service.model.*;
import Support.Service.repository.EquipmentRepository;
import Support.Service.repository.FailureRepository;
import Support.Service.repository.PersonRepository;
import Support.Service.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository supportTicketRepository;
    @Autowired
    private FailureRepository failureRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private PersonRepository personRepository;



    public List<SupportTicket> findAll() {
        return supportTicketRepository.findAll();
    }

    public SupportTicket findById(Long ticketId) {
        return supportTicketRepository.findById(ticketId).orElse(null);
    }


    public SupportTicket createTicket(User user, SupportTicketDto supportTicketDto) {
        SupportTicket supportTicket = new SupportTicket();
        Equipment equipment = equipmentRepository.findById(supportTicketDto.getEquipmentId()).orElse(null);
        Failure failure = failureRepository.findById(supportTicketDto.getFailureId()).orElse(null);

        if (equipment == null || failure == null) {
            throw new IllegalArgumentException("Invalid equipment or failure ID");
        }

        supportTicket.setUser(user);
        supportTicket.setEquipment(equipment);
        supportTicket.setFailure(failure);
        supportTicket.setSubject(supportTicketDto.getSubject());
        supportTicket.setTicketStatus(TicketStatus.OPEN);
        supportTicket.setCreatedAt(LocalDateTime.now());

        return supportTicketRepository.save(supportTicket);
    }



    public SupportTicket assignTicketToTechnician(Long ticketId, Long technicianId) {
        SupportTicket supportTicket = supportTicketRepository.findById(ticketId).orElseThrow(() -> new IllegalArgumentException("Invalid ticket ID"));
        Technician technician = (Technician) personRepository.findById(technicianId).orElseThrow(() -> new IllegalArgumentException("Invalid technician ID"));

        supportTicket.setTechnician(technician);
        supportTicket.setTicketStatus(TicketStatus.ASSIGNED);

        return supportTicketRepository.save(supportTicket);
    }



    public SupportTicket findTicketById(Long ticketId) {
        return supportTicketRepository.findById(ticketId).orElse(null);
    }


    public List<SupportTicket> findTicketsByTechnician(Long technicianId) {
        return supportTicketRepository.findSupportTicketByTechnicianPersonId(technicianId);
    }

    public SupportTicket updateTicketStatus(Long ticketId, TicketStatus newStatus) {
        SupportTicket supportTicket = supportTicketRepository.findById(ticketId).orElse(null);
        assert supportTicket != null;
        supportTicket.setTicketStatus(newStatus);
        return supportTicketRepository.save(supportTicket);
    }

    public List<SupportTicket> findTicketsByUser(Long userId) {
        return supportTicketRepository.findSupportTicketByUserPersonId(userId);
    }


}
