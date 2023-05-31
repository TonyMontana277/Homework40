package com.robot.Homework.dto;

import com.robot.Homework.domain.City;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StateDto {
    private Long id;
    private String name;
    private Integer population;
    private String cities;
}
