package com.eduquest.controller;

import com.eduquest.entity.Lesson;
import com.eduquest.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = "*")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @PostMapping
    public Lesson addLesson(@RequestBody Lesson lesson) {
        return lessonService.addLesson(lesson);
    }

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Lesson> getLessonsByCourse(@PathVariable Long courseId) {
        return lessonService.getLessonsByCourse(courseId);
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Long id,
                               @RequestBody Lesson lesson) {
        return lessonService.updateLesson(id, lesson);
    }

    @DeleteMapping("/{id}")
    public String deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return "Lesson deleted successfully";
    }
}
