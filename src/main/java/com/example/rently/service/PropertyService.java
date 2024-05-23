package com.example.rently.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.rently.model.PropertyEntity;
import com.example.rently.repository.PropertyRepository;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository pr;

    public ResponseEntity<PropertyEntity> addProperty(PropertyEntity pe) {
        try {
            pr.save(pe);
            return new ResponseEntity<>(pe, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PropertyEntity>> getAllPropertiesByPgNo(int pgNo) {
        try {
            // Define sorting criteria based on noOfLikes
            Sort sort = Sort.by(Sort.Direction.DESC, "noOfLikes");
            Page<PropertyEntity> p = pr.findAll(PageRequest.of(pgNo, 3 ,sort));
            return new ResponseEntity<>(p.getContent(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PropertyEntity> updateProperty(PropertyEntity pe) {
        try {
            pr.save(pe);
            return new ResponseEntity<>(pe, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PropertyEntity>> getAllProperties() {
        try {
            List<PropertyEntity> pe = pr.findAll();
            return new ResponseEntity<>(pe, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PropertyEntity>> getAllPropertiesBySeller(String id) {
        try {
            return new ResponseEntity<>(pr.getAllPropertiesBySeller(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PropertyEntity> getPropertyById(String id) {
        try {
            Optional<PropertyEntity> pe = pr.findById(id);
            if (pe.isPresent()) {
                return new ResponseEntity<>(pe.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deletePropertyById(String id) {
        try {
            pr.deleteById(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
