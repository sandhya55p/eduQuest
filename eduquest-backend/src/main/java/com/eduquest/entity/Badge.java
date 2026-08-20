package com.eduquest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "badges")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String badgeName;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private String rarity;

    @Column(nullable = false)
    private Boolean unlocked = false;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}