package Support.Service.controller;

import Support.Service.dto.SupportTicketDto;
import Support.Service.model.Person;
import Support.Service.model.SupportTicket;
import Support.Service.model.User;
import Support.Service.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/supportTicket")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;


    @PreAuthorize("hasRole('USER')")
    @PostMapping("/Create")
    public ResponseEntity<SupportTicket> createTicket(@AuthenticationPrincipal Person user, @RequestBody SupportTicketDto supportTicketDto) {
        User user1 = (User) user;
        SupportTicket supportTicket = supportTicketService.createTicket(user1, supportTicketDto);
        return new ResponseEntity<>(supportTicket, HttpStatus.CREATED);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{ticketId}/assign/{technicianId}")
    public ResponseEntity<SupportTicket> assignTicketToTechnician(
            @PathVariable Long ticketId,
            @PathVariable Long technicianId) {
        SupportTicket supportTicket = supportTicketService.assignTicketToTechnician(ticketId, technicianId);
        return new ResponseEntity<>(supportTicket, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('TECHNICIAN')")
    @PutMapping("/status-update/{ticketId}")
    public SupportTicket updateTicketStatus(@PathVariable Long ticketId, @RequestBody SupportTicket supportTicket) {
        return supportTicketService.updateTicketStatus(supportTicket,ticketId);

    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("all")
    public ResponseEntity<List<SupportTicket>> getAllTickets() {
        List<SupportTicket> tickets = supportTicketService.findAll();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('TECHNICIAN')")
    @GetMapping("/tech/{technicianId}")
    public ResponseEntity<List<SupportTicket>> getTechnicianTicket(@PathVariable Long technicianId) {
        List<SupportTicket> tickets =supportTicketService.findTicketsByTechnician(technicianId);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SupportTicket>> getTicketsByUser(@PathVariable Long userId) {
        List<SupportTicket> tickets = supportTicketService.findTicketsByUser(userId);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'TECHNICIAN')")
    @GetMapping("/{ticketId}")
    public ResponseEntity<SupportTicket> getTicketById(@PathVariable Long ticketId) {
        SupportTicket supportTicket = supportTicketService.findTicketById(ticketId);
        return new ResponseEntity<>(supportTicket, HttpStatus.OK);
    }

}
