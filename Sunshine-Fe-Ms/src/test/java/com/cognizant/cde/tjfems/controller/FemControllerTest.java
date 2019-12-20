package com.cognizant.cde.tjfems.controller;
import com.cognizant.cde.tjfems.model.Office;
import com.cognizant.cde.tjfems.service.ServiceLayer;
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
public class FemControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ServiceLayer serviceLayer;
    private String accessToken;
    private OauthHelper helper = new OauthHelper();
    private ObjectMapper mapper = new ObjectMapper();
    @Test
    public void givenNoToken_whenGetSecureRequest_thenUnauthorized() throws Exception {
        mockMvc.perform(get("/api/offices"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    public void givenToken_getOfficesShouldReturnOfficeList() throws Exception {
        List<Office> officeList = new ArrayList<>();
        Office office = new Office();
        office.setOfficeName("Cognizant");
        office.setStreetAddress("Broad Ave");
        office.setCity("Teaneck");
        office.setState("NJ");
        office.setZip("07777");
        office.setCountry("United States")
        officeList.add(office);
        Mockito.when(serviceLayer.getAllOffice()).thenReturn(officeList);
        String outputJson = mapper.writeValueAsString(officeList);
        accessToken = helper.getAccessToken("test", "test");
        mockMvc.perform(get("/api/offices").header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().json(outputJson));
    }
    @Test
    public void givenInvalidRole_whenPostOffice_thenForbidden() throws Exception {
        String accessToken = helper.getAccessToken("test", "test");
        mockMvc.perform(post("/api/offices")
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isForbidden());
    }
    @Test
    public void givenValidRole_whenPostOffice_ShouldReturnCreatedOffice() throws Exception {
        Office office = new Office();
        office.setOfficeName("Cognizant");
        office.setStreetAddress("Broad Ave");
        office.setCity("Teaneck");
        office.setState("NJ");
        office.setZip("07777");
        office.setCountry("United States");
        String inputJson = mapper.writeValueAsString(office);
        Office office2 = new Office();
        office2.setOfficeId(1l);
        office2.setOfficeName("Cognizant");
        office2.setStreetAddress("Broad Ave");
        office2.setCity("Teaneck");
        office.setState("NJ");
        office2.setZip("07777");
        office2.setCountry("United States")

        String outputJson = mapper.writeValueAsString(office2);
        Mockito.when(serviceLayer.createOffice(office)).thenReturn(office2);

        accessToken = helper.getAccessToken("admin", "admin");
        this.mockMvc.perform(post("/api/offices")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void givenValidRole_whenUpdateOffice_ShouldReturnUpdatedOffice() throws Exception {
        Office office = new Office();
        office.setOfficeId(1l);
        office.setOfficeName("Cognizant");
        office.setStreetAddress("Broad Ave");
        office.setCity("Teaneck");
        office.setState("NJ");
        office.setZip("07777");
        office.setCountry("United States");
        String inputJson = mapper.writeValueAsString(office);

        accessToken = helper.getAccessToken("admin", "admin");

        when(serviceLayer.updateOffice(office, 1l)).thenReturn(office);
        this.mockMvc.perform(put("/api/offices/1")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(inputJson));
    }

    @Test
    public void givenValidRole_whenUpdateOfficeWithWrongId_ShouldReturnThrowError() throws Exception {
        Office office = new Office();
        office.setOfficeId(1l);
        office.setOfficeName("Cognizant");
        office.setStreetAddress("Broad Ave");
        office.setCity("Teaneck");
        office.setState("NJ");
        office.setZip("07777");
        office.setCountry("United States");
        String inputJson = mapper.writeValueAsString(office);

        accessToken = helper.getAccessToken("admin", "admin");

        when(serviceLayer.updateOffice(office, 2l)).thenReturn(office);
        this.mockMvc.perform(put("/api/offices/2")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void givenValidRole_whenDeleteOffice_ShouldReturnMessage() throws Exception {

        String message = "Office 1 deleted";

        accessToken = helper.getAccessToken("admin","admin");

        when(serviceLayer.deleteOffice(1L)).thenReturn(message);
        this.mockMvc.perform(delete("/api/offices/1")
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(message));
    }
}
