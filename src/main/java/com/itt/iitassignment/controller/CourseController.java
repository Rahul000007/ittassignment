package com.itt.iitassignment.controller;

import com.itt.iitassignment.dto.CourseDTO;
import com.itt.iitassignment.service.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        CourseDTO createdCourseDTO = courseService.saveCourse(courseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourseDTO);

    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> listCourses() {
        List<CourseDTO> courseDTOList = courseService.getAllCourses();
        return ResponseEntity.ok(courseDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        CourseDTO courseDTO = courseService.getCourseById(id);
        return ResponseEntity.ok(courseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
