package com.cognizant.officecrud.service;

import com.cognizant.officecrud.model.Office;
import com.cognizant.officecrud.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    public String deleteOfficeById(Long Id){
        Office office = officeRepository.findById(Id).get();
        office.setActive(false);
        officeRepository.save(office);
        return "Office "+ Id + " deleted.";
    }
}
