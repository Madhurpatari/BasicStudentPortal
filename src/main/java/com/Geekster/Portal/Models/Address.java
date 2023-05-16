package com.Geekster.Portal.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    private String addressId;
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;
}
