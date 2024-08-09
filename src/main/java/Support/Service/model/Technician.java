package Support.Service.model;


import Support.Service.enums.FailureType;
import Support.Service.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<SupportTicket> tickets;

}

