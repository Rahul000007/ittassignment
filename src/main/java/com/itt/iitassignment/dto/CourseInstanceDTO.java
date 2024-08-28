package com.itt.iitassignment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseInstanceDTO {

    private Long courseInstanceId;

    @Min(2020)
    @NotNull
    private int year;

    @Min(1)
    @NotNull
    private int semester;

    @NotNull
    private Long courseId;
}
