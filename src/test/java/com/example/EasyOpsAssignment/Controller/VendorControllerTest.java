package com.example.EasyOpsAssignment.Controller;

import com.example.EasyOpsAssignment.DTOs.Request.VendorRequest;
import com.example.EasyOpsAssignment.Entity.Vendor;
import com.example.EasyOpsAssignment.Service.VendorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@WebMvcTest(value=VendorController.class)//removed secure=false
@RunWith(SpringRunner.class)
public class VendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VendorService vendorService;

    @Test
    public void addVendorTest() throws Exception {

        VendorRequest vendorRequest=new VendorRequest();
        vendorRequest.setAddress("h.no:78-2/g, chennai");
        vendorRequest.setCity("chennai");
        vendorRequest.setName("jagadesh");
        vendorRequest.setPhone("0987654321");
        vendorRequest.setEmail("jagadesh@yahoo.com");
        vendorRequest.setState("Kerala");
        vendorRequest.setPinCode("987654");

        String vendorInputInJson=this.mapToJson(vendorRequest);

        String URI="/api/v1/vendor/add";

        Vendor vendor=new Vendor();
        vendor.setVendorAddress("h.no:78-2/g, chennai");
        vendor.setCity("chennai");
        vendor.setVendorName("jagadesh");
        vendor.setPhone("0987654321");
        vendor.setEmail("jagadesh@yahoo.com");
        vendor.setState("Kerala");
        vendor.setPinCode("987654");


        Mockito.when(vendorService.addVendor(Mockito.any(VendorRequest.class))).thenReturn(String.valueOf(vendor));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON)//inputting format is JSON.
                .content(vendorInputInJson)//Content thats passed to Controller.
                .contentType(MediaType.APPLICATION_JSON);//outputting format is JSON.

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();//storing response from controller method into "response" object.

        String vendorOutputInJson = response.getContentAsString();//Converting response into String

        assertThat(vendorOutputInJson).isEqualTo(vendorInputInJson);//Asserting whether vendorOutputInJson
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getVendorByIdTest() throws Exception {

        VendorRequest vendorRequest=new VendorRequest();
        vendorRequest.setAddress("h.no:78-2/g, chennai");
        vendorRequest.setCity("chennai");
        vendorRequest.setName("jagadesh");
        vendorRequest.setPhone("0987654321");
        vendorRequest.setEmail("jagadesh@yahoo.com");
        vendorRequest.setState("Kerala");
        vendorRequest.setPinCode("987654");

        Vendor vendor=new Vendor();
        vendor.setVendorAddress("h.no:78-2/g, chennai");
        vendor.setCity("chennai");
        vendor.setVendorName("jagadesh");
        vendor.setPhone("0987654321");
        vendor.setEmail("jagadesh@yahoo.com");
        vendor.setState("Kerala");
        vendor.setPinCode("987654");

        Mockito.when(vendorService.getVendorById(Mockito.anyLong())).thenReturn(vendor);

        String URI = "/api/v1/vendor/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(vendorRequest);
        String vendorOutputInJson = result.getResponse().getContentAsString();
        String obj = vendorOutputInJson;
        Vendor sample=new ObjectMapper().readValue(vendorOutputInJson, Vendor.class);
        assertThat(vendorOutputInJson).isEqualTo(expectedJson);
    }

    //Mapping an Object into a JSON String. Uses a Jackson ObjectMapper.
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
