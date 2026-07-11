package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.business.bean.VendorBean;
import com.training.service.VendorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class VendorController {

    @Autowired
    private VendorService vendorServiceImpl;

    @GetMapping("/")
    public String index() {
        return "Welcome to Spring Boot Vendor Service API!";
    }

    @GetMapping("/vendor/controller/getVendors")
    public ResponseEntity<List<VendorBean>> getVendorDetails() {
        List<VendorBean> vendors = vendorServiceImpl.getVendorDetails();
        return ResponseEntity.ok(vendors);
    }
}