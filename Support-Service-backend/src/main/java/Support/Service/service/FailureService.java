package Support.Service.service;

import Support.Service.model.Failure;
import Support.Service.model.Person;
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


    @Autowired
    private EquipmentRepository equipmentRepository;


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

    public List<Failure> getFailureByEquipmentId(Long equipmentId) {
        return failureRepository.findFailureByEquipmentsId(equipmentId);
    }

}
