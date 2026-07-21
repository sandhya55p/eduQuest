package com.eduquest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="courses")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 1000)
    private String description;
    @Column(nullable = false)
    private  String category;
    @Column(nullable = false)
    private  String difficulty;
    private  String thumbnail;


}
