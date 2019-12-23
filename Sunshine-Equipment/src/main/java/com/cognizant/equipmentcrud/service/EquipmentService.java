package com.cognizant.equipmentcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.equipmentcrud.repository.EquipmentRepository;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public String deleteEquipmentById (Long id) {
        equipmentRepository.deleteById(id);
        return "Equipment: " + id + " deleted";
    }
}
