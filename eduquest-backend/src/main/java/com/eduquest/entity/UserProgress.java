package com.eduquest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_progress")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user","lesson"})
public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id",nullable = false)
    private Lesson lesson;

    private Boolean completed;

    private  Integer quizScore;

    private  Integer xpEarned;

    private  Integer coinsEarned;

    private LocalDateTime completedAt;
}
