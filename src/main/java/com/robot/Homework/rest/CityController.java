package com.robot.Homework.rest;

import com.robot.Homework.domain.City;
import com.robot.Homework.dto.CityDto;
import com.robot.Homework.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> getAllCities() {
        return ResponseEntity.ok(cityService.findAll());
    }


    @PostMapping(value = "/cities", consumes = {"application/xml", "application/json"})
    public City createCity(@RequestBody City city) {
        return cityService.save(city);
    }

}

