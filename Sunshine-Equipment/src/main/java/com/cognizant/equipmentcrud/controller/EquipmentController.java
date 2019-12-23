package com.cognizant.equipmentcrud.controller;

import com.cognizant.equipmentcrud.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.cognizant.equipmentcrud.repository.EquipmentRepository;
import com.cognizant.equipmentcrud.service.EquipmentService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    EquipmentService equipmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipment createEquipment(@RequestBody Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Equipment getEquipmentById(@RequestBody Equipment e, @PathVariable(name = "id") Long id) {
        if (id != e.getEquipmentId()){
            throw  new IllegalArgumentException("No match found");
        }
        return equipmentRepository.save(e);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteEquipment(@PathVariable(name = "id") Long id) {
        return equipmentService.deleteEquipmentById(id);
    }
}