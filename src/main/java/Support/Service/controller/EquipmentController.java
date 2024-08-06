package Support.Service.controller;

import Support.Service.model.Equipment;
import Support.Service.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/equipment")
@RestController
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> equipments = equipmentService.findAllEquipments();
        return ResponseEntity.ok(equipments);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return equipment;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{equipmentId}")
    public Equipment updateEquipment(@PathVariable Long equipmentId, @RequestBody Equipment equipment) {
        equipmentService.updateEquipment(equipmentId, equipment);
        return equipment;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{equipmentId}")
    public void deleteEquipment(@PathVariable Long equipmentId) {
        equipmentService.deleteEquipment(equipmentId);
    }
}
