package com.example.rently.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.rently.model.PropertyEntity;

public interface PropertyRepository extends JpaRepository<PropertyEntity, String> {
    
   @Query(value="SELECT p.* FROM properties p JOIN users u ON p.seller_id = u.id WHERE u.id=?1 ORDER BY p.name",nativeQuery=true)
    List<PropertyEntity> getAllPropertiesBySeller(String id);
}

