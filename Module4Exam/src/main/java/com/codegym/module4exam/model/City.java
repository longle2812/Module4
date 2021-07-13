package com.codegym.module4exam.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name can not be empty")
    private String name;

    @ManyToOne
    private Country country;

    @Min(value = 1,message = "Area must be a number and larger than 0")
    private double area;
    @Min(value = 1, message = "Population must be a number and larger than 0")
    private long population;
    @Min(value = 1, message = "GDP must be a number and larger than 0")
    private double GDP;

    private String description;

}
