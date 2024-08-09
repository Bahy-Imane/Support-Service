package Support.Service.controller;

import Support.Service.dto.PersonDto;
import Support.Service.dto.SignUpDto;
import Support.Service.model.Technician;
import Support.Service.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technician")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Technician>> getAllTechnicians() {
        List<Technician> technicians = technicianService.getAllTechnicians();
        return new ResponseEntity<>(technicians, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{technicianId}")
    public ResponseEntity<Technician> getTechnicianById(@PathVariable Long technicianId) {
        Technician technician = technicianService.getTechnicianById(technicianId);
        return new ResponseEntity<>(technician, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Technician> addTechnician(@RequestBody PersonDto personDto) {
        Technician newTechnician = technicianService.addTechnician(personDto);
        return new ResponseEntity<>(newTechnician, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{technicianId}")
    public ResponseEntity<Technician> updateTechnician(
            @PathVariable Long technicianId,
            @RequestBody Technician technician) {
        Technician updatedTechnician = technicianService.updateTechnician(technicianId, technician);
        return new ResponseEntity<>(updatedTechnician, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{technicianId}")
    public ResponseEntity<Void> deleteTechnicianById(@PathVariable Long technicianId) {
        technicianService.deleteTechnicianById(technicianId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

