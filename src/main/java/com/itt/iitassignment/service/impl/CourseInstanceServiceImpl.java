package com.itt.iitassignment.service.impl;

import com.itt.iitassignment.dto.CourseInstanceDTO;
import com.itt.iitassignment.model.Course;
import com.itt.iitassignment.model.CourseInstance;
import com.itt.iitassignment.repository.CourseInstanceRepository;
import com.itt.iitassignment.repository.CourseRepository;
import com.itt.iitassignment.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseInstanceServiceImpl implements CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public CourseInstanceDTO saveCourseInstance(CourseInstanceDTO courseInstanceDTO) {
        CourseInstance courseInstance = convertToEntity(courseInstanceDTO);
        CourseInstance savedCourseInstance = courseInstanceRepository.save(courseInstance);
        return convertToDTO(savedCourseInstance);
    }

    @Override
    public List<CourseInstanceDTO> getCourseInstancesByYearAndSemester(int year, int semester) {

        List<CourseInstance> courseInstances = courseInstanceRepository.findByYearAndSemester(year, semester);

        return courseInstances.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseInstanceDTO getCourseInstanceByCourseIdYearAndSemester(int year, int semester,Long courseId) {
        CourseInstance courseInstance = courseInstanceRepository.findByYearAndSemesterAndCourseId(year, semester,courseId).get();
        return convertToDTO(courseInstance);
    }

    @Override
    public CourseInstanceDTO getCourseInstanceById(Long instanceId) {
        CourseInstance courseInstance= courseInstanceRepository.findById(instanceId).get();
        return convertToDTO(courseInstance);
    }

    @Override
    public void deleteCourseInstance(Long id) {
        courseInstanceRepository.deleteById(id);
    }

    private CourseInstance convertToEntity(CourseInstanceDTO courseInstanceDTO) {
        CourseInstance courseInstance = new CourseInstance();
        courseInstance.setYear(courseInstanceDTO.getYear());
        courseInstance.setSemester(courseInstanceDTO.getSemester());
        Course course = courseRepository.findById(courseInstanceDTO.getCourseId()).get();
        courseInstance.setCourse(course);
        return courseInstance;
    }

    private CourseInstanceDTO convertToDTO(CourseInstance courseInstance) {
        CourseInstanceDTO courseInstanceDTO = new CourseInstanceDTO();
        courseInstanceDTO.setCourseInstanceId(courseInstance.getId());
        courseInstanceDTO.setYear(courseInstance.getYear());
        courseInstanceDTO.setSemester(courseInstance.getSemester());
        courseInstanceDTO.setCourseId(courseInstance.getCourse().getId());
        return courseInstanceDTO;
    }
}
