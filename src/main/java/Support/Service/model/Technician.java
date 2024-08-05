package Support.Service.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
@DiscriminatorValue("TECHNICIAN")
public class Technician extends Person {


    @OneToMany(mappedBy = "technician")
    private List<SupportTicket> tickets;


    @Override
    public String getRole() {
        return "ROLE_TECHNICIAN";
    }
}

