package com.mavs.productservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String price;

}
