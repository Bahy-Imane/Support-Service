package Support.Service.service;

import Support.Service.model.Failure;
import Support.Service.repository.EquipmentRepository;
import Support.Service.repository.FailureRepository;
import Support.Service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FailureService {

    @Autowired
    private FailureRepository failureRepository;


    public List<Failure> getAllFailures() {
        return failureRepository.findAll();
    }


    public Failure addFailure(Failure Failure) {
        return failureRepository.save(Failure);
    }


    public Failure updateFailure(Long failureId, Failure failure) {
        Failure failure1=failureRepository.findById(failureId).get();
        failure1.setDescription(failure.getDescription());
        failure1.setType(failure.getType());
        failureRepository.save(failure1);
        return failure1;
    }


    public void deleteFailure(Long failureId) {
        failureRepository.deleteById(failureId);
    }

//    public void failureSignal(Long userId,Long equipmentId, FailureDtoSignal failureDtoSignal) {
//        User user = (User) personRepository.findById(userId).orElseThrow(null);
//        Equipment equipment = equipmentRepository.findById(equipmentId).get();
//        Failure failure = new Failure();
//        failure.setUser(user);
//        failure.setEquipment(equipment);
//        failure.setDescription(failureDtoSignal.getDescription());
//        failure.setReportedAt(LocalDateTime.now());
//        failureRepository.save(failure);
//    }
//
//
//    public void registerFailure(FailureDto2 failureDto2) {
//        Failure failure = failureRepository.findByUserAndEquipment(
//                failureDto2.getUserId(), failureDto2.getEquipmentId()).orElseThrow(() -> new RuntimeException("Failure not found"));
//
//        failure.setDescription(failureDto2.getDescription());
//        failure.setFStatus(FailureStatus.valueOf(failureDto2.getStatut()));
//        failure.setReportedBy(failureDto2.getReportedBy());
//        failureRepository.save(failure);
//    }
//
//
//    public void updatePanneStatus(Long failureId, Failure failure) {
//        Failure failure1 = failureRepository.findById(failureId).orElseThrow();
//        failure1.setFStatus(failure.getFStatus());
//        failureRepository.save(failure1);
//    }

}
