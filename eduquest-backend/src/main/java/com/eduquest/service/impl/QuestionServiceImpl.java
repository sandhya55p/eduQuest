package com.eduquest.service.impl;

import com.eduquest.entity.Question;
import com.eduquest.repository.QuestionRepository;
import com.eduquest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }
    @Override
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }
    @Override
    public  Question getQuestionById(Long id){
        return  questionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Question not found "));

    }
    @Override
    public Question updateQuestion(Long id,Question question){
        Question existingQuestion =getQuestionById(id);
        existingQuestion.setQuestionText(question.getQuestionText());
        existingQuestion.setOptionA(question.getOptionA());
        existingQuestion.setOptionB(question.getOptionB());
        existingQuestion.setOptionC(question.getOptionC());
        existingQuestion.setOptionD(question.getOptionD());
        existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
        existingQuestion.setDifficulty(question.getDifficulty());
        existingQuestion.setPoints(question.getPoints());
        existingQuestion.setQuiz(question.getQuiz());
        return  questionRepository.save(existingQuestion);
    }
@Override
    public void deleteQuestion(Long id){
        questionRepository.deleteById(id);
}
@Override
    public  List<Question> getQuestionByQuiz(Long quizId){
        return questionRepository.findByQuizId(quizId);
}
}
