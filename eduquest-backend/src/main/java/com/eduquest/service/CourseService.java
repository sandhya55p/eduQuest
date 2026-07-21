package com.eduquest.service;

import com.eduquest.entity.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course updateCourse(Long id, Course course);
    void  deleteCourse(Long id);

}
