package com.eduquest.controller;

import com.eduquest.entity.Quiz;
import com.eduquest.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "*")
public class QuizeController {
    @Autowired
    public  QuizService quizService;
     @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz){
         return  quizService.createQuiz(quiz);
     }
     @GetMapping
    public List<Quiz> getAllQuizzes(){
         return quizService.getAllQuizzes();
     }
     @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id){
         return quizService.getQuizById(id);
     }
     @PutMapping
    public Quiz updateQuiz(@PathVariable Long id,  @RequestBody Quiz quiz){
         return quizService.updateQuiz(id,quiz);
     }
    @DeleteMapping("/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return "Quiz deleted successfully";
    }
    @GetMapping("/lesson/{lessonId}")
    public  List<Quiz> getQuizzesByLesson(@PathVariable Long lessonId){
         return  quizService.getQuizzesByLesson(lessonId);
    }
}
