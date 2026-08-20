package com.eduquest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "leaderboard")
@ToString(exclude = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalXP;

    private Integer totalCoins;

    private Integer totalAchievements;

    private Integer totalBadges;

    private Integer completedLessons;

    private Integer rankPosition;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
