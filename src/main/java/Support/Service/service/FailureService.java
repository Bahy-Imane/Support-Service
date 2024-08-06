package Support.Service.service;


import Support.Service.dto.FailureDtoSignal;
import Support.Service.model.Equipment;
import Support.Service.model.Failure;
import Support.Service.model.Person;
import Support.Service.model.User;
import Support.Service.repository.EquipmentRepository;
import Support.Service.repository.FailureRepository;
import Support.Service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FailureService {

    @Autowired
    private FailureRepository failureRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private PersonRepository personRepository;

    public List<Failure> getAllFailures() {
        return failureRepository.findAll();
    }

    public List<Failure> getEquipmentsFailures(Long equipmentId) {
        return failureRepository.findFailureByEquipment_EquipmentId(equipmentId);
    }



    public void failureSignal(Long userId,Long equipmentId, FailureDtoSignal failureDto) {
        User user = (User) personRepository.findById(userId).orElseThrow(null);
        Equipment equipment = equipmentRepository.findById(equipmentId).get();
        Failure failure = new Failure();
        failure.setUser(user);
        failure.setEquipment(equipment);
        failure.setDescription(failureDto.getDescription());
        failure.setReportedAt(LocalDateTime.now());
        failureRepository.save(failure);
    }


//    public void SaveFailure(FailureDto2 failureDto2) {
//        Failure failure = failureRepository.findById(failureDto2.getId()).orElseThrow();
//        failure.setStatut(panneDto.getStatut());
//        panne.setNotes(panneDto.getNotes());
//        panneRepository.save(panne);
//    }


//    public void updatePanneStatus(Long failureId, StatutDto statutDto) {
//        Panne panne = panneRepository.findById(id).orElseThrow();
//        panne.setStatut(statutDto.getStatut());
//        panneRepository.save(panne);
//    }

}
