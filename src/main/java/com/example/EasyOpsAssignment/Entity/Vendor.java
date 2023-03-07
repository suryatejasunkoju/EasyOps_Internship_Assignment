package com.example.EasyOpsAssignment.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    private String vendorName;
    private String vendorCode= UUID.randomUUID().toString();
    private String vendorAddress;
    private String city;
    private String state;
    private String pinCode;

    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;

    public Vendor() {
    }

    public Vendor(Long vendorId, String vendorName, String vendorCode, String vendorAddress, String city, String state, String pinCode, String phone, String email) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorCode = vendorCode;
        this.vendorAddress = vendorAddress;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.phone = phone;
        this.email = email;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
