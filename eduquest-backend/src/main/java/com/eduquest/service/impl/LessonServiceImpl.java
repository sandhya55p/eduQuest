package com.eduquest.service.impl;

import com.eduquest.entity.Lesson;
import com.eduquest.repository.LessonRepository;
import com.eduquest.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;
    @Override
    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    @Override
    public List<Lesson> getLessonsByCourse(Long courseId) {
        return lessonRepository.findByCourseId(courseId);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {

        Lesson existingLesson = getLessonById(id);

        existingLesson.setTitle(lesson.getTitle());
        existingLesson.setContent(lesson.getContent());
        existingLesson.setVideoUrl(lesson.getVideoUrl());
        existingLesson.setLessonOrder(lesson.getLessonOrder());
        existingLesson.setCourse(lesson.getCourse());

        return lessonRepository.save(existingLesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

}
