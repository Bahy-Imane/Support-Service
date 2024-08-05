package Support.Service.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Setter
@Getter
@Entity
@DiscriminatorValue("USER")
public class User extends Person {

    @OneToMany(mappedBy = "user")
    private List<Failure> failures;

    @OneToMany(mappedBy = "user")
    private List<SupportTicket> tickets;

    @Override
    public String getRole() {
        return "ROLE_USER";
    }

}

