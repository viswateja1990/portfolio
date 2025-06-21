package com.viswateja.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Degree {
    @Id
    private Long id;
    private String name;
    private String university;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

}