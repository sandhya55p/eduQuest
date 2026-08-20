package com.eduquest.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "questions")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "quiz")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String questionText;
    @Column(nullable = false)
    private String optionA;
    @Column(nullable = false)
    private  String optionB;
    @Column(nullable = false)
    private String optionC;
    @Column(nullable = false)
    private  String optionD;
    @Column(nullable = false)
    private String correctAnswer;
    private  String difficulty;
    private Long points;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
