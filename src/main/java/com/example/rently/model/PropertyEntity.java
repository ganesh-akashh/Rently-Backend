package com.example.rently.model;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "properties")
public class PropertyEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", nullable = false, unique = true)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "address")
    private String address;

     @Column(name = "name")
    private String name;


    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "features")
    private String features;

    @Column(name = "price")
    private double price;
    

    @Column(name="area")
    private String area;

    @Column(name="location")
    private String location;
    
    @Column(name="no_of_likes")
    private int noOfLikes;


    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "no_of_bath_rooms")
    private int noOfBathRooms;

    @Column(name = "no_of_bed_rooms")
    private int noOfBedRooms;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private UserEntity seller;

}
