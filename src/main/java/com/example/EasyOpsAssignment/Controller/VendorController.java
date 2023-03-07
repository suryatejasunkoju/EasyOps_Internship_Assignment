package com.example.EasyOpsAssignment.Controller;

import com.example.EasyOpsAssignment.DTOs.Response.ExceptionResponse.UserNotFoundExceptionResponse;
import com.example.EasyOpsAssignment.DTOs.Request.VendorRequest;
import com.example.EasyOpsAssignment.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/vendor")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity<>("Tested Successfully", HttpStatus.ACCEPTED);
    }
    @PostMapping("/add")
    public ResponseEntity addVendor(@Valid @RequestBody VendorRequest vendorRequest){
        //validate all fields here only. And if any rule is not followed then throw an Exception from here itself.
        return new ResponseEntity<>(vendorService.addVendor(vendorRequest), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{vendor_id}")
    public ResponseEntity getVendorById(@PathVariable("vendor_id") Long vendorId) throws Exception {
        return new ResponseEntity<>(vendorService.getVendorById(vendorId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{vendor_id}")
    public ResponseEntity updateVendor(@Valid @RequestBody VendorRequest vendorRequest, @PathVariable("vendor_id") Long vendorId) throws Exception {
        return new ResponseEntity<>(vendorService.updateVendor(vendorRequest,vendorId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/delete/{vendor_id}")
    public ResponseEntity deleteVendor(@PathVariable("vendor_id")Long vendorId) throws Exception {
        return  new ResponseEntity<>(vendorService.deleteVendorById(vendorId), HttpStatus.ACCEPTED);
    }
}
