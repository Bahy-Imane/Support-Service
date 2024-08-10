package Support.Service.controller;

import Support.Service.model.Equipment;
import Support.Service.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/equipment")
@RestController
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> equipments = equipmentService.findAllEquipments();
        return ResponseEntity.ok(equipments);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return equipment;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("(/update/{equipmentId}")
    public Equipment updateEquipment(@PathVariable Long equipmentId, @RequestBody Equipment equipment) {
        equipmentService.updateEquipment(equipmentId, equipment);
        return equipment;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{equipmentId}")
    public void deleteEquipment(@PathVariable Long equipmentId) {
        equipmentService.deleteEquipment(equipmentId);
    }
}
