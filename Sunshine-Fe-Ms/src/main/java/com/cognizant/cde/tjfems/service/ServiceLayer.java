package com.cognizant.cde.tjfems.service;

import com.cognizant.cde.tjfems.client.EquipmentCrudClient;
import com.cognizant.cde.tjfems.client.OfficeCrudClient;
import com.cognizant.cde.tjfems.model.Equipment;
import com.cognizant.cde.tjfems.model.ManagerToOffice;
import com.cognizant.cde.tjfems.model.Office;
import com.cognizant.cde.tjfems.repository.ManagerToOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLayer {

    @Autowired
    OfficeCrudClient officeCrudClient;

    @Autowired
    EquipmentCrudClient equipmentCrudClient;

    @Autowired
    ManagerToOfficeRepository managerToOfficeRepository;

    public ServiceLayer(OfficeCrudClient officeCrudClient) {
        this.officeCrudClient = officeCrudClient;
    }

    public Office createOffice(Office office) {
        return officeCrudClient.createOffice(office);
    }

    public String deleteOffice(Long id) {
        for (Equipment equipment:equipmentCrudClient.getAllEquipmentByOfficeId(id)) {
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

    public List<Office> getOfficesByManagerId() {
        Long id = getUserId();
        List<Long> officeIds = managerToOfficeRepository.findAllByManagerId(id)
                .stream()
                .map(ManagerToOffice::getOfficeId)
                .collect(Collectors.toList());

        if(officeIds.size() == 0) {
            return Collections.emptyList();
        }

        List<Office> offices = new ArrayList<>();
        for(Office office: officeCrudClient.getAllOffices()) {
            if(officeIds.contains(office.getOfficeId())) {
                offices.add(office);
            }
        }
        return offices;
    }

    public void saveManagerToOfficeAssociation(long managerId, long officeId) {
        ManagerToOffice association = new ManagerToOffice();
        association.setManagerId(managerId);
        association.setOfficeId(officeId);
        managerToOfficeRepository.save(association);
    }

    public void deleteManagerToOfficeAssociation(long managerId, long officeId) {
        ManagerToOffice association = new ManagerToOffice();
        association.setManagerId(managerId);
        association.setOfficeId(officeId);
        managerToOfficeRepository.delete(association);
    }


    public Long getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2Authentication castedAuthentication = (OAuth2Authentication) authentication;
        LinkedHashMap userInfo = (LinkedHashMap) castedAuthentication.getUserAuthentication().getDetails();
        return new Long(userInfo.get("id").toString());
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
