package com.cognizant.cde.tjfems.client;

import com.cognizant.cde.tjfems.model.Office;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="sunshine-office-crud", url="https://sunshine-office-crud.cfapps.io/")
public interface OfficeCrudClient {

    @PostMapping("/offices")
    public Office createOffice(@RequestBody Office office);

    @GetMapping("/offices")
    public List<Office> getAllOffices();

    @RequestMapping(value="/offices/office/{id}",  method = RequestMethod.GET)
    public Office getOfficeById(@PathVariable(name = "id") Long id);

    @RequestMapping(value="/offices/office/{id}",  method = RequestMethod.PUT)
    public Office updateOffice(@RequestBody Office office, @PathVariable(name = "id") Long id);

    @RequestMapping(value="/offices/office/{id}",  method = RequestMethod.DELETE)
    public String deleteOffice(@PathVariable(name = "id") Long id);

}
