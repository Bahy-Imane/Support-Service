package Support.Service.repository;

import Support.Service.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
