package com.Onlinenodue.Controller;

import com.Onlinenodue.DTO.Login;
import com.Onlinenodue.Repository.AdminRepo;
import com.Onlinenodue.Repository.LecturerRepo;
import com.Onlinenodue.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    public AdminRepo adminRepo;

    @Autowired
    public LecturerRepo lecturerRepo;

    @Autowired
    public StudentRepo studentRepo;

    @PostMapping("/userlogin")
    public ResponseEntity<?> loginverify(@RequestBody Login obj){
        if(obj.getUsertype().equals("Admin")){
            var admin = adminRepo.findById(Integer.valueOf(obj.getId())).orElseThrow(()->new RuntimeException("not found"));
            if(admin.getPassword().equals(obj.getPassword())){
                return new ResponseEntity<>("admin", HttpStatus.OK);
            }else{
                throw new RuntimeException("invalid password");
            }
        }

        if(obj.getUsertype().equals("Lecture")){
            var lecture = lecturerRepo.findById(Integer.valueOf(obj.getId())).orElseThrow(()->new RuntimeException("not found"));
            if(lecture.getPassword().equals(obj.getPassword())){
                return new ResponseEntity<>("lecture",HttpStatus.OK);
            }else{
                throw new RuntimeException("invalid password");
            }
        }

        if(obj.getUsertype().equals("Student")){
            var student = studentRepo.findByUsn(String.valueOf(obj.getId())).orElseThrow(()->new RuntimeException("not found"));
            if(student.getPassword().equals(obj.getPassword())){
                return new ResponseEntity<>("student",HttpStatus.OK);
            }else{
                throw new RuntimeException("invalid password");
            }
        }
        else {
            throw new RuntimeException("user not found");
        }
    }
}
