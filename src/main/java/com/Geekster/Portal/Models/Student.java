package com.Geekster.Portal.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private String studentId;
    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
