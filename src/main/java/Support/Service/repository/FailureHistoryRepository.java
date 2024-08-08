package Support.Service.repository;


import Support.Service.model.FailureHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FailureHistoryRepository extends JpaRepository<FailureHistory,Long> {
    public List<FailureHistory> findFailureHistoriesByEquipment_EquipmentId(Long equipmentId);
}
