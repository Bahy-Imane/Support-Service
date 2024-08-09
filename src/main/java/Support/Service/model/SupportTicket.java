package Support.Service.model;

import Support.Service.enums.TicketStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tickettId;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="equipment_id",nullable = false)
    private Equipment equipment;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "technician_id")
    private Technician technician;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "failure_id")
    private Failure failure;


}

