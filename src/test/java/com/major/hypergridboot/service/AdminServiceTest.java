package com.major.hypergridboot.service;

import com.major.hypergridboot.entity.Admin;
import com.major.hypergridboot.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceTest {

    private final Logger LOGGER = LoggerFactory.getLogger(AdminServiceTest.class);

    @Autowired
    private AdminService service;

    @MockBean
    private AdminRepository repository;

    @BeforeEach
    void setUp() {
        Admin admin = Admin.builder()
                .username("syamukonka")
                .name("Syamukonka Moonga")
                .password("123")
                .build();
        Mockito.when(repository.findByUsernameIgnoreCase("syamukonka")).thenReturn(admin);
    }

    @Test
    @DisplayName("Find admin, if username and password are correct")
    public void FindAdminIfUsernameAndPasswordAreValid(){
        Admin testAdmin = Admin.builder().username("syamukonka").password("123").build();
        Admin foundAdmin = service.loginAdmin(testAdmin);

        assertNotNull(foundAdmin);
        assertEquals( testAdmin.getUsername() , foundAdmin.getUsername());
        LOGGER.info("Admin Login passed");

    }


    @Test
    @DisplayName("Return Null, if password is wrong")
    public void ReturnNullIfPasswordIsInvalid(){
        Admin testAdmin = Admin.builder().username("syamukonka").password("wrong123").build();
        Admin foundAdmin = service.loginAdmin(testAdmin);

        assertNull(foundAdmin);
        LOGGER.info("Reject invalid credential [password] passed");

    }


    @Test
    @DisplayName("Return null, if username is wrong")
    public void ReturnNullIfUsernameIsInvalid(){
        Admin testAdmin = Admin.builder().username("yamuknka").password("123").build();
        Admin foundAdmin = service.loginAdmin(testAdmin);

        assertNull(foundAdmin);
        LOGGER.info("Reject invalid credential [username] passed");

    }
}