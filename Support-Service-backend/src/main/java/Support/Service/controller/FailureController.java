package Support.Service.controller;

import Support.Service.model.Failure;
import Support.Service.service.EquipmentService;
import Support.Service.service.FailureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/failure")
public class FailureController {

    @Autowired
    private FailureService failureService;

    @Autowired
    private EquipmentService equipmentService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{equipmentId}")
    public ResponseEntity<Failure> getFailure(@PathVariable Long equipmentId) {
        Failure failure = (Failure) failureService.getFailureByEquipmentId(equipmentId);
        return ResponseEntity.ok(failure);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Failure> addFailure(@RequestBody Failure failure) {
        failureService.addFailure(failure);
        return ResponseEntity.ok(failure);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{failureId}")
    public ResponseEntity<Failure> updateFailure(@PathVariable Long failureId, @RequestBody Failure failure) {
        failureService.updateFailure(failureId, failure);
        return ResponseEntity.ok(failure);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{failureId}")
    public void deleteFailure(@PathVariable Long failureId) {
        failureService.deleteFailure(failureId);
    }
}
