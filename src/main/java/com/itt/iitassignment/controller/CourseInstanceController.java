package com.itt.iitassignment.controller;

import com.itt.iitassignment.dto.CourseInstanceDTO;
import com.itt.iitassignment.service.CourseInstanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping
    public ResponseEntity<CourseInstanceDTO> createCourseInstance(@Valid @RequestBody CourseInstanceDTO courseInstanceDTO) {
        CourseInstanceDTO savedCourseInstanceDTO = courseInstanceService.saveCourseInstance(courseInstanceDTO);
        return ResponseEntity.ok(savedCourseInstanceDTO);
    }

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstanceDTO>> courseInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        List<CourseInstanceDTO> courseInstanceDTOS = courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
        return ResponseEntity.ok(courseInstanceDTOS);
    }

    @GetMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstanceDTO> getCourseInstanceByCourseIdYearAndSemester(@PathVariable int year, @PathVariable int semester, @PathVariable Long courseId) {
        CourseInstanceDTO courseInstanceDTO = courseInstanceService.getCourseInstanceByCourseIdYearAndSemester(year, semester,courseId);
        return ResponseEntity.ok(courseInstanceDTO);
    }

    @GetMapping("/{instanceId}")
    public ResponseEntity<CourseInstanceDTO> getCourseInstanceById(@PathVariable Long instanceId) {
        CourseInstanceDTO courseInstanceDTO= courseInstanceService.getCourseInstanceById(instanceId);
        return ResponseEntity.ok(courseInstanceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseInstance(@PathVariable Long id) {
        courseInstanceService.deleteCourseInstance(id);
        return ResponseEntity.noContent().build();
    }
}
