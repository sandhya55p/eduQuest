package com.eduquest.service.impl;

import com.eduquest.entity.Quiz;
import com.eduquest.repository.QuizeRepository;
import com.eduquest.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizeRepository quizeRepository;
    @Override
    public  Quiz createQuiz(Quiz quiz){
        return  quizeRepository.save(quiz);
    }
    @Override
    public  List<Quiz> getAllQuizzes(){
        return quizeRepository.findAll();

    }
    @Override
    public Quiz getQuizById(Long id){
        return  quizeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Quiz not found"));
    }
    @Override
    public Quiz updateQuiz(Long id, Quiz quiz){
        Quiz existingQuiz= getQuizById(id);
        existingQuiz.setQuestion(quiz.getQuestion());
        existingQuiz.setOptionA(quiz.getOptionA());
        existingQuiz.setOptionB(quiz.getOptionB());
        existingQuiz.setOptionC(quiz.getOptionC());
        existingQuiz.setOptionD(quiz.getOptionD());
        existingQuiz.setCorrectAnswer(quiz.getCorrectAnswer());
        existingQuiz.setDifficulty(quiz.getDifficulty());
        existingQuiz.setDifficulty(quiz.getDifficulty());
        existingQuiz.setXpReward(quiz.getXpReward());
        existingQuiz.setLesson(quiz.getLesson());
        return  quizeRepository.save(existingQuiz);
    }

    @Override
    public void deleteQuiz(Long id) {
        quizeRepository.deleteById(id);
    }


    @Override
    public  List<Quiz> getQuizzesByLesson(Long lessonId){
        return quizeRepository.findByLessonId(lessonId);
    }

}
