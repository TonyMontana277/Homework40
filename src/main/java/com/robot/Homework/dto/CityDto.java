package com.robot.Homework.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDto {
    private Long id;
    private String name;
    private Integer population;
    private Long stateId;
}
