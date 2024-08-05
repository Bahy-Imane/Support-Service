package Support.Service.repository;


import Support.Service.model.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
}
