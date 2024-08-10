package Support.Service.model;

import Support.Service.enums.FailureType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "failure")
public class Failure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long failureId;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private FailureType type;

    @OneToMany(mappedBy = "failure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SupportTicket> supportTickets;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "failure_equipment",
            joinColumns = @JoinColumn(name = "failure_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<Equipment> equipments;
}
