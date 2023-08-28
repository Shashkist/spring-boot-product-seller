package com.sha.springbootproductseller.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
//import java.util.Set;

@Data
@Entity
@Table(name ="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false)
    private  String description;

    @Column(nullable = false)
    private Double price;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//    private Set<Purchase> purchaseList;





}
