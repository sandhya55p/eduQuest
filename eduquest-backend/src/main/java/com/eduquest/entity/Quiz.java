package com.eduquest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="quizzes")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private  String optionA;

    @Column(nullable = false)
    private  String optionB;

    @Column(nullable = false)
    private  String optionC;

    @Column(nullable = false)
    private String optionD;

    @Column(nullable = false)
    private  String correctAnswer;


    private  String difficulty;

    private  Integer xpReward;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
