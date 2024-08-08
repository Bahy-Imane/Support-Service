package Support.Service.service;

import Support.Service.model.FailureHistory;
import Support.Service.repository.FailureHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FailureHistoryService {

    @Autowired
    private FailureHistoryRepository failureHistoryRepository;

     public List<FailureHistory> getAllFailureHistory() {
         return failureHistoryRepository.findAll();
     }

    public List<FailureHistory> getFailureHistoryByEquipment(Long equipmentId) {
        return failureHistoryRepository.findFailureHistoriesByEquipment_EquipmentId(equipmentId);
    }
}
