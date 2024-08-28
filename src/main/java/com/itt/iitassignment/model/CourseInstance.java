package com.itt.iitassignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class CourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(2024)
    private int year;

    @NotNull
    @Min(1)
    private int semester;

    @ManyToOne
    @NotNull

    private Course course;

}
