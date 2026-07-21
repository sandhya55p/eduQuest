package com.eduquest.service;

import com.eduquest.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(Quiz quiz);

    List<Quiz> getAllQuizzes();

    Quiz getQuizById(Long id);

    Quiz updateQuiz(Long id, Quiz quiz);

    void deleteQuiz(Long id);

    List<Quiz> getQuizzesByLesson(Long lessonId);
}
