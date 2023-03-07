package com.example.EasyOpsAssignment.Service;

import com.example.EasyOpsAssignment.DTOs.Response.ExceptionResponse.UserNotFoundExceptionResponse;
import com.example.EasyOpsAssignment.DTOs.Request.VendorRequest;
import com.example.EasyOpsAssignment.Entity.Vendor;
import com.example.EasyOpsAssignment.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    VendorRepository vendorRepository;

    public String addVendor(VendorRequest vendorRequest){
        Vendor vendor=new Vendor();
        vendor.setVendorName(vendorRequest.getName());
        vendor.setCity(vendorRequest.getCity());
        vendor.setEmail(vendorRequest.getEmail());
        vendor.setPhone(vendorRequest.getPhone());
        vendor.setState(vendorRequest.getState());
        vendor.setVendorAddress(vendorRequest.getAddress());
        vendor.setPinCode(vendorRequest.getPinCode());
        vendorRepository.save(vendor);
        return "Vendor created Successfully !!!";
    }

    public Vendor getVendorById(Long vendorId) {
        Optional<Vendor> optionalVendor=vendorRepository.findById(vendorId);
        if(!optionalVendor.isPresent()){
//            throw  new Exception(vendorId+"");
        }
        return optionalVendor.get();
    }

    public Vendor updateVendor(VendorRequest vendorRequest,Long vendorId) throws Exception {
        Optional<Vendor> optionalVendor=vendorRepository.findById(vendorId);
        if(!optionalVendor.isPresent()){
            throw new Exception(vendorId+"");
        }

        Vendor vendor=optionalVendor.get();
        //updating attributes
        vendor.setPinCode(vendorRequest.getPinCode());
        vendor.setCity(vendorRequest.getCity());
        vendor.setEmail(vendorRequest.getEmail());
        vendor.setVendorName(vendorRequest.getName());
        vendor.setState(vendorRequest.getState());
        vendor.setVendorAddress(vendorRequest.getAddress());
        vendor.setPhone(vendorRequest.getPhone());
        //saving into DB
        vendorRepository.save(vendor);
        return vendor;
    }

    public String deleteVendorById(Long vendorId) throws Exception {
        Optional<Vendor> optional=vendorRepository.findById(vendorId);
        if (!optional.isPresent()){
            throw new Exception(vendorId+"");
        }
        Vendor vendor=optional.get();
        vendorRepository.deleteById(vendorId);
        return "Deleted Vendor Successfully !!!";
    }
}