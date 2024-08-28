package com.itt.iitassignment.service.impl;

import com.itt.iitassignment.dto.CourseDTO;
import com.itt.iitassignment.dto.CourseInstanceDTO;
import com.itt.iitassignment.model.Course;
import com.itt.iitassignment.model.CourseInstance;
import com.itt.iitassignment.repository.CourseInstanceRepository;
import com.itt.iitassignment.repository.CourseRepository;
import com.itt.iitassignment.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return convertToDTO(savedCourse);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> course = courseRepository.findAll();
        return course.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        return convertToDTO(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseInstanceRepository.deleteByCourseId(id);
        courseRepository.deleteById(id);
    }

    private Course convertToEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setCourseCode(courseDTO.getCourseCode());
        course.setDescription(courseDTO.getDescription());
        return course;
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setDescription(course.getDescription());
        return courseDTO;
    }

}
