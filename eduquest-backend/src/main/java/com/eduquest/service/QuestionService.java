package com.eduquest.service;

import com.eduquest.entity.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion( Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    Question updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
    List<Question> getQuestionByQuiz(Long quizId);
}
