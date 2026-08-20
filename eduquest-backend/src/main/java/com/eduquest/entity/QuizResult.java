package com.eduquest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "quiz_results")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude =  {"user", "lesson"} )
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;
     @Column(nullable = false)
    private Integer score=0;
     @Column(nullable = false)
    private Integer totalQuestions=0;
     @Column(nullable = false)
    private Integer correctAnswers=0;
    @Column(nullable = false)
    private Integer xpEarned = 0;

    @Column(nullable = false)
    private Integer coinsEarned = 0;

    private LocalDateTime completedAt;



}
