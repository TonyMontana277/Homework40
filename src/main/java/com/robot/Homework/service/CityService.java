package com.robot.Homework.service;

import com.robot.Homework.domain.City;
import com.robot.Homework.dto.CityDto;
import com.robot.Homework.repository.CityRepository;
import com.robot.Homework.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final StateRepository stateRepository;

    public City save(City city) {

        cityRepository.save(city);
        return city;
    }

    public List<CityDto> findAll() {
        return cityRepository.findAll()
                .stream()
                .map(CityService::buildCityDto)
                .collect(Collectors.toList());
    }

    private static CityDto buildCityDto(City city) {
        Long stateId = null;
        if (city.getState() != null) {
            stateId = city.getState().getId();
        }
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .population(city.getPopulation())
                .stateId(stateId)
                .build();
    }

    public void addState(Long cityId, Long stateId){
        var state = stateRepository.findById(stateId).get();
        var city = cityRepository.findById(cityId).get();
        city.setState(state);

        cityRepository.save(city);
    }

}
