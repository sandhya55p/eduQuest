package com.eduquest.service.impl;

import com.eduquest.entity.Course;
import com.eduquest.repository.CourseRepository;
import com.eduquest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
    @Override
    public  Course updateCourse(Long id, Course course){
        Course existingCourse= getCourseById(id);
        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setCategory(course.getCategory());
        existingCourse.setDifficulty(course.getDifficulty());
        existingCourse.setThumbnail(course.getThumbnail());
        return  courseRepository.save(existingCourse);


    }
    @Override
    public  void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

}
