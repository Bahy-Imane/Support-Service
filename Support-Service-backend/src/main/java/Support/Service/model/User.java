package Support.Service.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;


@Setter
@Getter
@Entity
@DiscriminatorValue("USER")
public class User extends Person {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private List<SupportTicket> tickets;

}

