package Support.Service.controller;

import Support.Service.model.Failure;
import Support.Service.service.EquipmentService;
import Support.Service.service.FailureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/failure")
public class FailureController {

    @Autowired
    private FailureService failureService;



    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<Failure>> getAllFailures() {
        List<Failure> failures = failureService.getAllFailures();
        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(failures);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all/{equipmentId}")
    public ResponseEntity<Failure> getFailure(@PathVariable Long equipmentId) {
        Failure failure = (Failure) failureService.getFailureByEquipmentId(equipmentId);
        return ResponseEntity.ok(failure);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Failure> addFailure(@RequestBody Failure failure) {
        failureService.addFailure(failure);
        return ResponseEntity.ok(failure);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{failureId}")
    public ResponseEntity<Failure> updateFailure(@PathVariable Long failureId, @RequestBody Failure failure) {
        failureService.updateFailure(failureId, failure);
        return ResponseEntity.ok(failure);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{failureId}")
    public void deleteFailure(@PathVariable Long failureId) {
        failureService.deleteFailure(failureId);
    }
}
