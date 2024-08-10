package Support.Service.repository;

import Support.Service.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUserNameOrEmail(String userName,String email);
    Person findByUserName(String userName);
    Person findByEmail(String email);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
}
