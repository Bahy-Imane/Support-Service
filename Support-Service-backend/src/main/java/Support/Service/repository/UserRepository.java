package Support.Service.repository;

import Support.Service.enums.Role;
import Support.Service.model.Technician;
import Support.Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByRole(Role role);
}
