package Support.Service.service;

import Support.Service.dto.PersonDto;
import Support.Service.dto.SignUpDto;

import Support.Service.enums.Role;
import Support.Service.model.Technician;
import Support.Service.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    public Technician getTechnicianById(Long technicianId) {
        return technicianRepository.findById(technicianId).get();
    }

    public Technician addTechnician(PersonDto personDto) {
        Technician technician = new Technician();
        technician.setUserName(personDto.getUserName());
        technician.setEmail(personDto.getEmail());
        technician.setRole(Role.TECHNICIAN);
        technician.setPassword(passwordEncoder.encode(personDto.getPassword()));
        return technicianRepository.save(technician);
    }

    public void deleteTechnicianById(Long technicianId) {
        technicianRepository.deleteById(technicianId);
    }

    public Technician updateTechnician(Long technicianId,Technician technician) {
        Technician technician1=technicianRepository.findById(technicianId).get();
        technician1.setEmail(technician.getEmail());
        technician1.setUserName(technician.getUsername());
        return technicianRepository.save(technician1);

        }

    }


