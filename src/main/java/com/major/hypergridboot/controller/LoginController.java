package com.major.hypergridboot.controller;

import com.major.hypergridboot.entity.Admin;
import com.major.hypergridboot.repository.AdminRepository;
import com.major.hypergridboot.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class LoginController {

    @Autowired
    AdminService service;
    AdminRepository repository;

    private final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public Admin loginAdmin(@RequestBody Admin admin){
        LOGGER.info("Attempting Log-in: "+admin.getUsername()+" - "+admin.getPassword());
        return service.loginAdmin(admin);
    }

    @GetMapping("/")
    public String helloWorld(){
        return "Hello!! You're my world";
    }

}
