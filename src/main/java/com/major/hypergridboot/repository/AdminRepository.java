package com.major.hypergridboot.repository;

import com.major.hypergridboot.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByUsernameIgnoreCase(String username);
}
