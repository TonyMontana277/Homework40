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
public class City {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "city_id", nullable = false)
        private Long id;

        @Column(name = "city_name")
        private String name;

        @Column(name = "city_population")
        private Integer population;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "country_id")
        private         State state;
    }