package Support.Service.repository;

import Support.Service.model.Failure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FailureRepository extends JpaRepository<Failure, Long> {

    @Query(value = "select * from failure where equipment_id=?",nativeQuery = true)
    List<Failure> findFailureByEquipment_EquipmentId(Long id);

}
