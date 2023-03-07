package com.example.EasyOpsAssignment.DTOs.Request;

import javax.validation.constraints.*;

public class VendorRequest {
    @NotNull(message = "name can't be empty/null")
    @Size(min=3, max = 40, message = "No. of characters in name should be in limit: >=3 and <=40")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain only Characters")
    private String name;

    @NotBlank
    @Email(message = "Please enter a valid Email address")
    private String email;
    @NotBlank(message = "address can't be empty/null")
    private String address;
    @NotBlank(message = "City can't be empty/null")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "City should contain only characters")
    private String city;
    @NotBlank(message = "state can't be empty/null")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "state should contain only characters" )
    private String state;
    @NotBlank(message = "pinCode can't be empty/null")
    @Pattern(regexp = "^\\d{6}$", message = "PinCode should contain only 6 numbers")
    private String pinCode;
    @NotBlank(message = "Phone can't be empty/null")
    @Pattern(regexp = "^\\d{10}$",message = "Phone should contain only 10 numbers")
    private String phone;


    public VendorRequest() {
    }

    public VendorRequest(String name, String email, String address, String city, String state, String pinCode, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "VendorRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
