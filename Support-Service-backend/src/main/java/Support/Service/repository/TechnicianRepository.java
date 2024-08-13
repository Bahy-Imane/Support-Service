package Support.Service.repository;

import Support.Service.enums.Role;
import Support.Service.model.Technician;
import Support.Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    List<Technician> findTechnicianByRole(Role role);
}
