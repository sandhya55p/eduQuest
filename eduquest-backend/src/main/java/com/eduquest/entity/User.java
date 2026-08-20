package com.eduquest.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table (name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class User {
    @Id //it makes  id column as the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatically generates id values
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private Integer totalCoins =0;
    @Column(nullable = false)
    private Integer totalXP=0;
    @Column(nullable = false)
    private Integer level=1;
    @Column(nullable = false)
    private Integer currentStreak = 0;
    @Column(nullable = false)
    private Integer longestStreak = 0;
}




