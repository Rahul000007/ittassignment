package com.itt.iitassignment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseDTO {

    private Long courseId;

    @NotBlank
    private String title;

    @NotBlank
    private String courseCode;

    private String description;
}
