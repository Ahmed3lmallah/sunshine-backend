package com.cognizant.cde.tjfems.controller;

import com.cognizant.cde.tjfems.client.EquipmentCrudClient;

import com.cognizant.cde.tjfems.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentCrudClient equipmentCrudClient;

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentCrudClient.getAllEquipment();
    }

    @GetMapping("/{equipmentId}")
    public Equipment getEquipmentByEquipmentId(@PathVariable(name = "equipmentId") Long equipmentId){
        return equipmentCrudClient.getEquipmentByEquipmentId(equipmentId);
    }

    @GetMapping("/office/{officeId}")
    public List<Equipment> getEquipmentByOfficeId(@PathVariable(name = "officeId") Long officeId){
        return equipmentCrudClient.getAllEquipmentByOfficeId(officeId);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipment publicRegister(@RequestBody Equipment equipment) {
        return equipmentCrudClient.registerEquipment(equipment);
    }

    @DeleteMapping("/{equipmentId}")
    public String deleteEquipment(@PathVariable(name = "equipmentId") Long equipmentId){
        return equipmentCrudClient.deleteEquipment(equipmentId);
    }

    @PutMapping("/{equipmentId}")
    public Equipment updateEquipment(@RequestBody Equipment equipment, @PathVariable(name = "equipmentId") Long equipmentId) {
        return equipmentCrudClient.updateEquipment(equipment, equipmentId);
    }
}
