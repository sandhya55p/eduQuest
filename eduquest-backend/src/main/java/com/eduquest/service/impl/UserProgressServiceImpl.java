package com.eduquest.service.impl;

import com.eduquest.entity.UserProgress;
import com.eduquest.repository.UserProgressRepository;
import com.eduquest.service.UserProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProgressServiceImpl implements UserProgressService {
    @Autowired
    private UserProgressRepository userProgressRepository;
    @Override
    public UserProgress saveProgress(UserProgress progress){
        return  userProgressRepository.save(progress);
    }
    @Override
    public List<UserProgress> getAllProgress(){
        return userProgressRepository.findAll();
    }
   @Override
    public UserProgress getProgressById(Long id){
        return userProgressRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Progress not found"));
   }
   @Override
    public UserProgress updateProgress(Long id ,UserProgress progress){
        UserProgress existing =getProgressById(id);
        existing.setUser(progress.getUser());
        existing.setLesson(progress.getLesson());
        existing.setCompleted(progress.getCompleted());
        existing.setQuizScore(progress.getQuizScore());
        existing.setXpEarned(progress.getXpEarned());
        existing.setCoinsEarned(progress.getCoinsEarned());
        existing.setCompletedAt(progress.getCompletedAt());
        return userProgressRepository.save(existing);
   }
   @Override
    public void deleteProgress(Long id){
        userProgressRepository.deleteById(id);
   }
   @Override
    public List<UserProgress> getProgressByUser(Long userId){
        return userProgressRepository.findByUserId(userId);
   }
   @Override
    public  List<UserProgress> getProgressByLesson(Long lessonId){
        return userProgressRepository.findByLessonId(lessonId);
   }
}
