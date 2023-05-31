package com.robot.Homework.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "state_name")
    private String name;

    @Column(name = "state_population")
    private Integer population;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private List<City> cities;


}
