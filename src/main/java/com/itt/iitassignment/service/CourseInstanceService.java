package com.itt.iitassignment.service;

import com.itt.iitassignment.dto.CourseDTO;
import com.itt.iitassignment.dto.CourseInstanceDTO;

import java.util.List;

public interface CourseInstanceService {
    CourseInstanceDTO saveCourseInstance(CourseInstanceDTO courseInstance);

    List<CourseInstanceDTO> getCourseInstancesByYearAndSemester(int year, int semester);

    CourseInstanceDTO getCourseInstanceByCourseIdYearAndSemester(int year, int semester, Long courseId);

    CourseInstanceDTO getCourseInstanceById(Long instanceId);

    void deleteCourseInstance(Long id);
}
