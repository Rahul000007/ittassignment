package com.itt.iitassignment.repository;

import com.itt.iitassignment.model.CourseInstance;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(int year, int semester);

    Optional<CourseInstance> findByYearAndSemesterAndCourseId(int year, int semester, Long courseId);

    @Modifying
    @Transactional
    @Query("DELETE FROM CourseInstance ci WHERE ci.course.id = :courseId")
    void deleteByCourseId(Long courseId);
}
