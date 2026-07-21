package com.eduquest.repository;

import com.eduquest.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  QuizeRepository extends JpaRepository<Quiz,Long> {
    List<Quiz> findByLessonId(Long lessonId);
}
