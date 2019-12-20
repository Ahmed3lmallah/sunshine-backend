package com.cognizant.cde.tjfems.service;
import com.cognizant.cde.tjfems.model.Office;
import org.junit.Before;
import org.junit.Test;
import com.cognizant.cde.tjfems.client.OfficeCrudClient;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    private OfficeCrudClient officeCrudClient;
    private ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {
        setUpOfficeCrudClientMock();
        serviceLayer = new ServiceLayer(officeCrudClient);
    }

    public void setUpOfficeCrudClientMock(){
        officeCrudClient = mock(OfficeCrudClient.class);
        List<Office> officeList = new ArrayList();

        Office officeBeingReturned = new Office();
        officeBeingReturned.setOfficeId(1l);
        officeBeingReturned.setOfficeName("Cognizant");
        officeBeingReturned.setStreetAddress("Broad Ave");
        officeBeingReturned.setCity("Teaneck");
        officeBeingReturned.setState("NJ");
        officeBeingReturned.setZip("07777");
        officeBeingReturned.setCountry("United States")

        officeList.add(officeBeingReturned);

        Office officeInput = new Office();
        officeInput.setOfficeName("Cognizant");
        officeInput.setStreetAddress("Broad Ave");
        officeInput.setCity("Teaneck");
        officeInput.setState("NJ");
        officeInput.setZip("07777");
        officeInput.setCountry("United States");
        Mockito.when(officeCrudClient.createOffice(officeInput)).thenReturn(officeBeingReturned);
        Mockito.when(officeCrudClient.getAllOffices()).thenReturn(officeList);
        Mockito.when(officeCrudClient.getOfficeById(1l)).thenReturn(officeBeingReturned);
    }

    @Test
    public void createGetOffice() {
        Office office = new Office();
        office.setOfficeName("Cognizant");
        office.setStreetAddress("Broad Ave");
        office.setCity("Teaneck");
        office.setState("NJ");
        office.setZip("07777");
        office.setCountry("United States");

        office = serviceLayer.createOffice(office);

        Office fromService = serviceLayer.getOffice(1l);

        assertEquals(office,fromService);
    }

    @Test
    public void getAllOffice() {
        Office office = new Office();
        office.setOfficeName("Cognizant");
        office.setStreetAddress("Broad Ave");
        office.setCity("Teaneck");
        office.setState("NJ");
        office.setZip("07777");
        office.setCountry("United States");
        List<Office> officeList = new ArrayList<>();
        officeList.add(office);

        List<Office> fromService = serviceLayer.getAllOffice();

        assertEquals(officeList.size(),fromService.size());
    }
}