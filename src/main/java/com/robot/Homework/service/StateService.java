package com.robot.Homework.service;

import com.robot.Homework.domain.State;
import com.robot.Homework.dto.StateDto;
import com.robot.Homework.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepository stateRepository;
    public void save(State state){

        stateRepository.save(state);
    }

    public List<StateDto> findAll(){
        return stateRepository.findAll()
                .stream()
                .map(StateService::buildStateDto)
                .collect(Collectors.toList());
    }

    private static StateDto buildStateDto(State state){
        return StateDto.builder()
                .id(state.getId())
                .name(state.getName())
                .population(state.getPopulation())
                .cities(String.valueOf(state.getCities()))
                .build();
    }


}

