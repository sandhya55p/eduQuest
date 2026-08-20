package com.eduquest.repository;

import com.eduquest.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProgressRepository extends JpaRepository<UserProgress,Long> {
    List<UserProgress> findByUserId(Long userId);
    List<UserProgress> findByLessonId(Long lessonId);
    Optional<UserProgress> findByUserIdAndLessonId(Long userId, Long lessonId);
}
