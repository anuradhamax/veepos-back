package com.mathalee.veepos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @Column(name = "productId", length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column(name = "productName",length = 255,nullable = false)
    private String productName;



    @Column(name = "activeState", columnDefinition = "TINYINT default 1")
    private boolean activeState;
}
