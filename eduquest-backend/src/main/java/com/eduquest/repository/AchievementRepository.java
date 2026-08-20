package com.eduquest.repository;

import com.eduquest.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement,Long> {

}
