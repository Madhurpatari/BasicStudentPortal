package com.Geekster.Portal.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {
    @Id
    private String laptopId;
    private String name;
    private String brand;
    private Integer price;
    @OneToOne(  cascade = CascadeType.ALL)
    private Student student;
}
