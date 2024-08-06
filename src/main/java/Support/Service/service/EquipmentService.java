package Support.Service.service;


import Support.Service.model.Equipment;
import Support.Service.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {


        @Autowired
        private EquipmentRepository equipmentRepository;

        public List<Equipment> findAllEquipments() {
            return equipmentRepository.findAll();
        }


        public Equipment findEquipmentById(Long equipmentId) {

            return equipmentRepository.findById(equipmentId).orElse(null);
        }


        public Equipment saveEquipment(Equipment equipment) {
            return equipmentRepository.save(equipment);
        }

        public Equipment updateEquipment(Long equipmentId, Equipment equipment) {
            Equipment equipment1 = equipmentRepository.findById(equipmentId)
                    .orElseThrow(() -> new RuntimeException("Equipment not found"));
            equipment1.setName(equipment.getName());
            equipment1.setStatus(equipment.getStatus());
            equipment1.setType(equipment.getType());
            equipment1.setImg(equipment.getImg());
            return equipmentRepository.save(equipment1);
        }

    public void deleteEquipment(Long equipmentId) {
        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        equipmentRepository.delete(equipment);
    }

}
