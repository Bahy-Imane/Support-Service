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
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional
    public SupportTicket createTicket(User user, SupportTicketDto supportTicketDto) {
        SupportTicket supportTicket = new SupportTicket();
        Equipment equipment = equipmentRepository.findById(supportTicketDto.getEquipmentId()).orElse(null);
        Failure failure = failureRepository.findById(supportTicketDto.getFailureId()).orElse(null);

        supportTicket.setSubject(supportTicketDto.getSubject());
        supportTicket.setEquipment(equipment);
        supportTicket.setFailure(failure);
        supportTicket.setUser(user);

        supportTicket.setTicketStatus(TicketStatus.REPORTED);
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



    public SupportTicket updateTicketStatus(SupportTicket supportTicket,Long ticketId) {
        SupportTicket supportTicket1 = supportTicketRepository.findById(ticketId).orElse(null);
        assert supportTicket != null;
        supportTicket1.setTicketStatus(supportTicket.getTicketStatus());
        return supportTicketRepository.save(supportTicket1);
    }

    public SupportTicket updateTicket(Long ticketId,TicketStatus newStatus) {
        SupportTicket supportTicket1 = supportTicketRepository.findById(ticketId).orElse(null);
        assert supportTicket1 != null;
        supportTicket1.setTicketStatus(newStatus);
        return supportTicketRepository.save(supportTicket1);
    }

    public List<SupportTicket> findTicketsByUser(Long userId) {
        return supportTicketRepository.findSupportTicketByUserPersonId(userId);
    }

    public List<SupportTicket> findTicketsByTechnician(Long technicianId) {
        return supportTicketRepository.findSupportTicketByTechnicianPersonId(technicianId);
    }


}
