package Support.Service.repository;


import Support.Service.model.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
    List<SupportTicket> findSupportTicketByTechnicianPersonId(Long technicianId);
    List<SupportTicket> findSupportTicketByUserPersonId(Long userId);
}
