package com.cognizant.cde.tjfems.controller;

import com.cognizant.cde.tjfems.client.OfficeCrudClient;
import com.cognizant.cde.tjfems.model.Office;
import com.cognizant.cde.tjfems.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/offices")
public class OfficeController {

    @Autowired
    private ServiceLayer serviceLayer;

    @Autowired
    OfficeCrudClient officeCrudClient;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Office createOffice(@RequestBody Office office) {
        return serviceLayer.createOffice(office);
    }

    @GetMapping
    public List<Office> getAllOffices(){
        return serviceLayer.getAllOffice();
    }

    @GetMapping("/manager/{managerId}")
    public List<Office> getOfficesByManagerId(@PathVariable(name = "managerId") Long managerId){
        return officeCrudClient.getOfficesByManagerId(managerId);
    }

    @GetMapping("/{id}")
    public Office getOfficeById(@PathVariable(name = "id") Long id) {
        return serviceLayer.getOffice(id);
    }

    @PutMapping("/{id}")
    public Office updateOffice(@RequestBody Office office, @PathVariable(name = "id") Long id){
        if(id != office.getOfficeId()){
            throw new IllegalArgumentException("No match found");
        }
        return serviceLayer.updateOffice(office, id);
    }

    @DeleteMapping("/{id}")
    public String deleteOffice(@PathVariable(name = "id") Long id) {
        return serviceLayer.deleteOffice(id);
    }
}
