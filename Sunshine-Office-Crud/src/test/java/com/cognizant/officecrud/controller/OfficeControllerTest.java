package com.cognizant.officecrud.controller;

import com.cognizant.officecrud.model.Office;
import com.cognizant.officecrud.repository.OfficeRepository;
import com.cognizant.officecrud.service.OfficeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OfficeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OfficeService officeService;

    @MockBean
    OfficeRepository officeRepository;

    private String accessToken;
    private OauthHelper helper = new OauthHelper();
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void givenNoToken_whenGetSecureRequest_thenUnauthorized() throws Exception {
        mockMvc.perform(get("/offices"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void givenToken_getOfficesShouldReturnOfficeList() throws Exception {

        List<Office> officeList = new ArrayList<>();

        Office ofc = new Office();
        ofc.setOfficeId(1L);
        ofc.setOfficeName("Delivery Center");
        ofc.setStreetAddress("5001 Statesman Drive Suite 175 & 200");
        ofc.setCity("Irving");
        ofc.setZip("75063");
        officeList.add(ofc);
        Mockito.when(officeRepository.findAll()).thenReturn(officeList);

        String outputJson = mapper.writeValueAsString(officeList);

        accessToken = helper.getAccessToken("test", "test");

        mockMvc.perform(get("/offices").header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().json(outputJson));
    }

    @Test
    public void givenInvalidRole_whenPostOffice_thenForbidden() throws Exception {
        String accessToken = helper.getAccessToken("test", "test");
        mockMvc.perform(post("/offices")
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isForbidden());
    }

    @Test
    public void givenValidRole_whenPostOffice_ShouldReturnCreatedOffice() throws Exception {
        Office inputOfc = new Office();
        inputOfc.setOfficeName("Delivery Center");
        inputOfc.setStreetAddress("5001 Statesman Drive Suite 175 & 200");
        inputOfc.setCity("Irving");
        inputOfc.setZip("75063");

        String inputJson = mapper.writeValueAsString(inputOfc);

        Office outputOfc = new Office();
        outputOfc.setOfficeId(1L);
        outputOfc.setOfficeName("Delivery Center");
        outputOfc.setStreetAddress("5001 Statesman Drive Suite 175 & 200");
        outputOfc.setCity("Irving");
        outputOfc.setZip("75063");
        String outputJson = mapper.writeValueAsString(outputOfc);

        accessToken = helper.getAccessToken("000000","password");

        when(officeRepository.save(inputOfc)).thenReturn(outputOfc);
        this.mockMvc.perform(post("/offices")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void givenValidRole_whenPutOffice_ShouldReturnUpdatedOffice() throws Exception {

        Office inputOfc = new Office();
        inputOfc.setOfficeId(1L);
        inputOfc.setOfficeName("New Delivary Center");
        inputOfc.setStreetAddress("5001 Statesman Drive Suite 175 & 200");
        inputOfc.setCity("Plano");
        inputOfc.setZip("75063");
        String inputJson = mapper.writeValueAsString(inputOfc);

        accessToken = helper.getAccessToken("000000","password");

        when(officeRepository.save(inputOfc)).thenReturn(inputOfc);
        this.mockMvc.perform(put("/offices/office/1")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(inputJson));
    }

    @Test
    public void givenValidRole_whenPutOfficeWithWrongId_ShouldThrowError() throws Exception {

        Office inputOfc = new Office();
        inputOfc.setOfficeId(1L);
        inputOfc.setOfficeName("New Delivary Center");
        inputOfc.setStreetAddress("5001 Statesman Drive Suite 175 & 200");
        inputOfc.setCity("Plano");
        inputOfc.setZip("75063");
        String inputJson = mapper.writeValueAsString(inputOfc);

        accessToken = helper.getAccessToken("000000","password");

        when(officeRepository.save(inputOfc)).thenReturn(inputOfc);
        this.mockMvc.perform(put("/offices/office/2")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void givenValidRole_whenDeleteOffice_ShouldReturnMessage() throws Exception {

        String message = "Office 1 deleted";

        accessToken = helper.getAccessToken("000000","password");

        when(officeService.deleteOfficeById(1L)).thenReturn(message);
        this.mockMvc.perform(delete("/offices/office/1")
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(message));
    }
}