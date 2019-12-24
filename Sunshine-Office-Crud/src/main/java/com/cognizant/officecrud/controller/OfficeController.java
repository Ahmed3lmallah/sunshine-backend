package com.cognizant.officecrud.controller;

import com.cognizant.officecrud.model.Office;
import com.cognizant.officecrud.repository.OfficeRepository;
import com.cognizant.officecrud.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/offices")
public class OfficeController {

    @Autowired
    OfficeRepository officeRepository;

    @Autowired
    OfficeService officeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Office createOffice(@RequestBody Office office) {
        return officeRepository.save(office);
    }

    @GetMapping
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    @GetMapping("/manager/{managerId}")
    public List<Office> getOfficesByManagerId(@PathVariable Long managerId) {
        return officeRepository.findOfficeByManagerId(managerId);
    }

    @RequestMapping(value="/office/{id}",  method = RequestMethod.GET)
    public Office getOfficeById(@PathVariable(name = "id") Long id) {
        return officeRepository.findById(id).orElse(new Office());
    }

    @RequestMapping(value="/office/{id}",  method = RequestMethod.PUT)
    public Office updateOffice(@RequestBody Office office, @PathVariable(name = "id") Long id) {
        if(id != office.getOfficeId()){
            throw new IllegalArgumentException("No match found");
        }
        return officeRepository.save(office);
    }

    @RequestMapping(value="/office/{id}",  method = RequestMethod.DELETE)
    public String deleteOffice(@PathVariable(name = "id") Long id) {
         return officeService.deleteOfficeById(id);
    }

}