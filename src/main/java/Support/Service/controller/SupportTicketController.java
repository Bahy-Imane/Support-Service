package Support.Service.controller;

import Support.Service.dto.SupportTicketDto;
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

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;


    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<SupportTicket> createTicket(@AuthenticationPrincipal User user, @RequestBody SupportTicketDto supportTicketDto) {
        SupportTicket supportTicket = supportTicketService.createTicket(user, supportTicketDto);
        return new ResponseEntity<>(supportTicket, HttpStatus.CREATED);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{ticketId}/assign/{technicianId}")
    public ResponseEntity<SupportTicket> assignTicketToTechnician(
            @PathVariable Long ticketId,
            @PathVariable Long technicianId) {
        SupportTicket supportTicket = supportTicketService.assignTicketToTechnician(ticketId, technicianId);
        return new ResponseEntity<>(supportTicket, HttpStatus.OK);
    }


//    @GetMapping("/{ticketId}")
//    public ResponseEntity<SupportTicket> getTicketById(@PathVariable Long ticketId) {
//        SupportTicket supportTicket = supportTicketService.findById(ticketId);
//        if (supportTicket == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(supportTicket, HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<List<SupportTicket>> getAllTickets() {
//        List<SupportTicket> tickets = supportTicketService.findAll();
//        return new ResponseEntity<>(tickets, HttpStatus.OK);
//    }

    @PreAuthorize("hasRole('ROLE_TECHNICIAN')")
    @GetMapping("/technician/{technicianId}")
    public ResponseEntity<List<SupportTicket>> getTicketsByTechnician(@PathVariable Long technicianId) {
        List<SupportTicket> tickets = supportTicketService.findTicketsByTechnician(technicianId);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SupportTicket>> getTicketsByUser(@PathVariable Long userId) {
        List<SupportTicket> tickets = supportTicketService.findTicketsByUser(userId);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}
