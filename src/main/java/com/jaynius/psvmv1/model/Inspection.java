package com.jaynius.psvmv1.model;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Inspection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean speedGovernor,seatBelts,wipers,windShield,windows,tires,brakes;
    
    @CreatedDate
    private LocalDate registrationDate;

    @UpdateTimestamp
    private LocalDate inspectionDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_registration")
    private Vehicle vehicle;
    
}
