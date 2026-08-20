package com.eduquest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "achievements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    @Column(nullable = false)
    private String achievementType;
    @Column(nullable = false)
    private Integer targetValue;

    @Column(nullable = false)
    private Integer requiredXP;

    private Integer rewardXP;

    private Integer rewardCoins;

    private String badgeIcon;


}