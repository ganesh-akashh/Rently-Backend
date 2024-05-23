package com.example.rently.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rently.model.PropertyEntity;
import com.example.rently.service.PropertyService;

@RestController
@CrossOrigin
@RequestMapping("property")
public class PropertyController {
    @Autowired
    PropertyService ps;

    @PostMapping("/addProperty")
    public ResponseEntity<PropertyEntity> addProperty(@RequestBody PropertyEntity pe) {
        return ps.addProperty(pe);
    }

    //Pagination
    @GetMapping("/getAllPropertiesByPgNo/{pgNo}")
    public ResponseEntity<List<PropertyEntity>> getAllPropertiesByPgNo(@PathVariable int pgNo) {
  
        return ps.getAllPropertiesByPgNo(pgNo);
    }

    @GetMapping("/getAllProperties")
    public ResponseEntity<List<PropertyEntity>> getAllProperties() {
        return ps.getAllProperties();
    }

    @GetMapping("/getAllPropertiesBySeller/{id}")
    public ResponseEntity<List<PropertyEntity>> getAllPropertiesBySeller(@PathVariable String id) {
        return ps.getAllPropertiesBySeller(id);
    }

    @GetMapping("/getPropertyById/{id}")
    public ResponseEntity<PropertyEntity> getPropertyById(@PathVariable String id) {
        return ps.getPropertyById(id);
    }

    @DeleteMapping("/deletePropertyById/{id}")
    public ResponseEntity<String> deletePropertyById(@PathVariable String id) {
        return ps.deletePropertyById(id);
    }

    @PutMapping("/updateProperty")
    public ResponseEntity<PropertyEntity> updateProperty(@RequestBody PropertyEntity pe) {
        return ps.updateProperty(pe);
    }
}
