package com.eduquest.repository;

import com.eduquest.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProgressRepository extends JpaRepository<UserProgress,Long> {
    List<UserProgress> findByUserId(Long userId);
    List<UserProgress> findByLessonId(Long lessonId);
}
