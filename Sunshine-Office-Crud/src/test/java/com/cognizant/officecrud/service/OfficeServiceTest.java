package com.cognizant.officecrud.service;

import com.cognizant.officecrud.model.Office;
import com.cognizant.officecrud.repository.OfficeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OfficeServiceTest {

    @MockBean
    OfficeRepository officeRepository;

    @Autowired
    OfficeService officeService;

    @Test
    public void deleteOfficeById() {
        Office ofc = new Office();
        ofc.setOfficeId(1L);
        ofc.setOfficeName("Delivery Center");
        ofc.setStreetAddress("5001 Statesman Drive Suite 175 & 200");
        ofc.setCity("Irving");
        ofc.setZip("75063");
        ofc.setActive(false);

        Mockito.when(officeRepository.findById(1L)).thenReturn(Optional.of(ofc));
        Mockito.when(officeRepository.save(ofc)).thenReturn(ofc);

        String result = officeService.deleteOfficeById(1L);
        assertEquals("Office 1 deleted.", result);
    }
}