package com.example.rently.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.rently.model.UserEntity;
import com.example.rently.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository ur;

    public ResponseEntity<UserEntity> addUser(UserEntity ue) {
        try {
            ur.save(ue);
            return new ResponseEntity<>(ue, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteUserById(String id) {
        try {
            ur.deleteById(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<UserEntity> getUserById(String id) {
        try {
            Optional<UserEntity> ue = ur.findById(id);
            if (ue.isPresent()) {
                return new ResponseEntity<>(ue.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<UserEntity> getUserByEmail(String email) {
        try {
            Optional<UserEntity> ue = ur.findByEmail(email);
            if (ue.isPresent()) {
                return new ResponseEntity<>(ue.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
