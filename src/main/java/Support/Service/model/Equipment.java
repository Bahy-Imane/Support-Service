package Support.Service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String EqStatus;

    @Column(nullable = false)
    private String img;

    @OneToMany
    @JsonIgnore
    private List<SupportTicket> supportTicket;

    @OneToMany(mappedBy = "equipment")
    @JsonIgnore
    private List<FailureHistory> failureHistory;



}
