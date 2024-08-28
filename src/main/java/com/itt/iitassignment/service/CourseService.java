package com.itt.iitassignment.service;

import com.itt.iitassignment.dto.CourseDTO;
import com.itt.iitassignment.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseDTO saveCourse(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();

    CourseDTO getCourseById(Long id);

    void deleteCourse(Long id);
}
