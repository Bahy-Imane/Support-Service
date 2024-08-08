package Support.Service.controller;

import Support.Service.model.Failure;
import Support.Service.service.FailureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/failure")
public class FailureController {

    @Autowired
    private FailureService failureService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Failure> addFailure(@RequestBody Failure failure) {
        failureService.addFailure(failure);
        return ResponseEntity.ok(failure);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{failureId}")
    public ResponseEntity<Failure> updateFailure(@PathVariable Long failureId, @RequestBody Failure failure) {
        failureService.updateFailure(failureId, failure);
        return ResponseEntity.ok(failure);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{failureId}")
    public void deleteFailure(@PathVariable Long failureId) {
        failureService.deleteFailure(failureId);
    }
}
