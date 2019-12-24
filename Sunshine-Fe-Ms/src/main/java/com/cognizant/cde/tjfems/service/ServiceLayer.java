package com.cognizant.cde.tjfems.service;

import com.cognizant.cde.tjfems.client.EquipmentCrudClient;
import com.cognizant.cde.tjfems.client.OfficeCrudClient;
import com.cognizant.cde.tjfems.model.Equipment;
import com.cognizant.cde.tjfems.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    OfficeCrudClient officeCrudClient;

    @Autowired
    EquipmentCrudClient equipmentCrudClient;

    public ServiceLayer(OfficeCrudClient officeCrudClient) {
        this.officeCrudClient = officeCrudClient;
    }

    public Office createOffice(Office office) {
        return officeCrudClient.createOffice(office);
    }

    public String deleteOffice(Long id) {
        for (Equipment equipment:equipmentCrudClient.getEquipmentByOfficeId(id)) {
            equipmentCrudClient.deleteEquipment(equipment.getEquipmentId());
        }
        return officeCrudClient.deleteOffice(id);
    }

    public Office updateOffice(Office office, Long id) {
        return officeCrudClient.updateOffice(office, id);
    }

    public Office getOffice(Long id) {
        return officeCrudClient.getOfficeById(id);
    }

    public List<Office> getAllOffice() {
        return officeCrudClient.getAllOffices();
    }

    //equipment operations
    public List<Equipment> getAllEquipment() {
        return equipmentCrudClient.getAllEquipment();
    }

    public Equipment getEquipmentByEquipmentId(Long equipmentId){
        return equipmentCrudClient.getEquipmentByEquipmentId(equipmentId);
    }

    public Equipment publicRegister(Equipment equipment) {
        return equipmentCrudClient.registerEquipment(equipment);
    }

    public String deleteEquipment(Long equipmentId){
        return equipmentCrudClient.deleteEquipment(equipmentId);
    }

    public Equipment updateEquipment(Equipment equipment,Long equipmentId) {
        return equipmentCrudClient.updateEquipment(equipment, equipmentId);
    }

}
