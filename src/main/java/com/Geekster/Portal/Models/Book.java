package com.Geekster.Portal.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String bookId;
    private String title;
    private String author;
    private String description;
    private String price;
    @ManyToOne
    private Student student;
}
