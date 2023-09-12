package com.apidemo.SpringBoot2Hours.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;



import java.util.Date;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",nullable = false, unique = true, length = 300)
    private String name;
    @Column(name = "year")
    private int year;
    @Column(name = "price")
    private Double price;
    @Column(name = "url")
    private String url;

    @Column(name = "birthDate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    @Column(name = "status")
    private boolean status;


}
