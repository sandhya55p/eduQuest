package com.eduquest.service;

import com.eduquest.entity.Lesson;

import java.util.List;

public interface LessonService {
    Lesson addLesson(Lesson lesson);

    List<Lesson> getAllLessons();

    Lesson getLessonById(Long id);

    List<Lesson> getLessonsByCourse(Long courseId);

    Lesson updateLesson(Long id, Lesson lesson);

    void deleteLesson(Long id);

}
