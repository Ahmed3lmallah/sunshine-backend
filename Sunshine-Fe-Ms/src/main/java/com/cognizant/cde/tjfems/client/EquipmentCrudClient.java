package com.cognizant.cde.tjfems.client;

import com.cognizant.cde.tjfems.model.Equipment;
import com.cognizant.cde.tjfems.model.User;
import com.cognizant.cde.tjfems.model.UserViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="sunshine-equipment-crud") //url="https://sunshine-equipment-crud.cfapps.io/"
public interface EquipmentCrudClient {
    @GetMapping("/equipment")
    List<Equipment> getAllEquipment();

    @GetMapping("/equipment/{equipmentId}")
    Equipment getEquipmentByEquipmentId(@PathVariable(name = "equipmentId") Long equipmentId);

    @PostMapping("/equipment/register")
    Equipment registerEquipment(@RequestBody Equipment equipment);

    @DeleteMapping("/equipment/{equipmentId}")
    String deleteEquipment(@PathVariable(name = "equipmentId") Long equipmentId);

    @PutMapping("equipment/{equipmentId}")
    Equipment updateEquipment(@RequestBody Equipment equipment, @PathVariable(name = "equipmentId") Long equipmentId);

    @GetMapping("/equipment/{officeId}")
    List<Equipment> getAllEquipmentByOfficeId(@PathVariable(name = "officeId") Long officeId);

}
