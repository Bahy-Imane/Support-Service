package Support.Service.controller;


import Support.Service.model.FailureHistory;
import Support.Service.service.FailureHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/failure-History")
public class FailureHistoryController {

    @Autowired
    private FailureHistoryService failureHistoryService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<FailureHistory> getFailureHistory(Long equipmentId) {
        return failureHistoryService.getFailureHistoryByEquipment(equipmentId);
    }
}
