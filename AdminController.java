package com.Onlinenodue.Controller;

import com.Onlinenodue.Entity.Admin;
import com.Onlinenodue.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminRepo adminRepo;

    @PutMapping("/updatepassword")
    public ResponseEntity<?> updatepassword(@RequestBody Admin obj)
    {
        var admin=adminRepo.findById(obj.getId()).orElseThrow(()->new RuntimeException("Not found"));
        admin.setPassword(obj.getPassword());
        adminRepo.save(admin);
        return new ResponseEntity<>("Password update successfully", HttpStatus.OK);
    }
}
