package com.eduquest.controller;

import com.eduquest.entity.Question;
import com.eduquest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return  questionService.createQuestion(question);
    }
    @GetMapping
    public List<Question> getAllQuestions(){
        return  questionService.getAllQuestions();
    }
    @GetMapping("/{id}")
    public  Question getQuestionById(@PathVariable Long id){
        return  questionService.getQuestionById(id);
    }
    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id,
                                   @RequestBody Question question){
        return questionService.updateQuestion(id,question);
    }
    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id){
         questionService.deleteQuestion(id);
         return "Question deleted successfully ";
    }
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionByQuiz(@PathVariable Long quizId){
        return questionService.getQuestionByQuiz(quizId);
    }

}
