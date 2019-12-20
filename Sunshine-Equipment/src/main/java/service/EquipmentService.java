package service;

import model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EquipmentRepository;

@Service
public class EquipmentService {
    @Autowired
    EquipmentRepository equipmentRepository;
    public String equipmentDeleteById (Long id) {
        equipmentRepository.deleteById(id);
        return "Equipment: " + id + " deleted";
    }
}
