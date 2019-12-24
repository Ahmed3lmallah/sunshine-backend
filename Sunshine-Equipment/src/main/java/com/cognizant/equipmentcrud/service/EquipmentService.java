package com.cognizant.equipmentcrud.service;

import com.cognizant.equipmentcrud.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.equipmentcrud.repository.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public String deleteEquipmentById (Long id) {
        equipmentRepository.deleteById(id);
        return "Equipment: " + id + " deleted";
    }

    public List<Equipment> getEquipmentByOfficeId(Long officeId){
        return equipmentRepository.getEquipmentByOfficeId(officeId);
    }

}
