package com.example.rently.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rently.model.UserEntity;
import com.example.rently.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService us;

    @PostMapping("/addUser")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity ue) {
       return us.addUser(ue);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable String id) {
         return us.getUserById(id);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id){
        return us.deleteUserById(id);
    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable String email){
        return us.getUserByEmail(email);
    }

}
