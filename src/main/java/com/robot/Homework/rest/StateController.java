package com.robot.Homework.rest;

import java.util.List;
import com.robot.Homework.domain.State;
import com.robot.Homework.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StateController {

    private final StateRepository stateRepository;

    @GetMapping("/states")
    public List<State> getAllStates(){
        return stateRepository.findAll();
    }



    @PostMapping(value = "/states", consumes = {"application/xml","application/json"})
    public State createState(@RequestBody State state){
        return stateRepository.save(state);

    }
}
