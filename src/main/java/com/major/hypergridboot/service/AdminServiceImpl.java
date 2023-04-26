package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Admin;
import com.major.hypergridboot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository repository;
    @Override
    public Admin loginAdmin(Admin admin) {
        Admin found = repository.findByUsernameIgnoreCase(admin.getUsername());
        if(found == null)
            return null;
        else if(admin.getPassword().equals(found.getPassword()))
            return found;
        else return null;
    }
}
