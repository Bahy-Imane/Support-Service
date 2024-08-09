package Support.Service.repository;

import Support.Service.model.Failure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface FailureRepository extends JpaRepository<Failure, Long> {
    @Query(value = "select f from Failure f JOIN f.equipments e  where e.equipmentId = :equipment_id")
    List<Failure> findFailureByEquipmentsId(Long equipment_id);

}
