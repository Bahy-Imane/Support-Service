package Support.JUnit.test;

import Support.Service.model.Equipment;
import Support.Service.repository.EquipmentRepository;
import Support.Service.service.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class EquipmentServiceTest {

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private EquipmentService equipmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllEquipments() {
        Equipment equipment = new Equipment();
        equipment.setName("Printer");
        equipment.setType("Office");
        equipment.setStatus("Working");
        equipment.setImg("printer.jpg");

        when(equipmentRepository.findAll()).thenReturn(List.of(equipment));

        List<Equipment> equipments = equipmentService.findAllEquipments();
        assertNotNull(equipments);
        assertEquals(1, equipments.size());
        assertEquals("Printer", equipments.get(0).getName());
    }

    @Test
    public void testFindEquipmentById() {
        Equipment equipment = new Equipment();
        equipment.setName("Printer");
        equipment.setType("Office");
        equipment.setStatus("Working");
        equipment.setImg("printer.jpg");

        when(equipmentRepository.findById(anyLong())).thenReturn(Optional.of(equipment));

        Equipment foundEquipment = equipmentService.findEquipmentById(1L);
        assertNotNull(foundEquipment);
        assertEquals("Printer", foundEquipment.getName());
    }

    @Test
    public void testSaveEquipment() {
        Equipment equipment = new Equipment();
        equipment.setName("Printer");
        equipment.setType("Office");
        equipment.setStatus("Working");
        equipment.setImg("printer.jpg");

        when(equipmentRepository.save(any(Equipment.class))).thenReturn(equipment);

        Equipment savedEquipment = equipmentService.saveEquipment(equipment);
        assertNotNull(savedEquipment);
        assertEquals("Printer", savedEquipment.getName());
        verify(equipmentRepository).save(any(Equipment.class));
    }

    @Test
    public void testUpdateEquipment() {
        Equipment existingEquipment = new Equipment();
        existingEquipment.setName("Old Printer");
        existingEquipment.setType("Office");
        existingEquipment.setStatus("Not Working");
        existingEquipment.setImg("old_printer.jpg");

        Equipment updatedEquipment = new Equipment();
        updatedEquipment.setName("New Printer");
        updatedEquipment.setType("Office");
        updatedEquipment.setStatus("Working");
        updatedEquipment.setImg("new_printer.jpg");

        when(equipmentRepository.findById(anyLong())).thenReturn(Optional.of(existingEquipment));
        when(equipmentRepository.save(any(Equipment.class))).thenReturn(updatedEquipment);

        Equipment result = equipmentService.updateEquipment(1L, updatedEquipment);
        assertNotNull(result);
        assertEquals("New Printer", result.getName());
        assertEquals("Working", result.getStatus());
        verify(equipmentRepository).save(any(Equipment.class));
    }

    @Test
    public void testDeleteEquipment() {
        Equipment equipment = new Equipment();
        equipment.setName("Printer");
        equipment.setType("Office");
        equipment.setStatus("Working");
        equipment.setImg("printer.jpg");

        when(equipmentRepository.findById(anyLong())).thenReturn(Optional.of(equipment));

        equipmentService.deleteEquipment(1L);
        verify(equipmentRepository).delete(any(Equipment.class));
    }

    @Test
    public void testDeleteEquipmentNotFound() {
        when(equipmentRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            equipmentService.deleteEquipment(1L);
        });

        assertEquals("Equipment not found", exception.getMessage());
    }
}
