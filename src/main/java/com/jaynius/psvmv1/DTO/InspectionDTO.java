package com.jaynius.psvmv1.DTO;

import java.time.LocalDate;

import com.jaynius.psvmv1.model.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class InspectionDTO {
    private long id;
    private boolean speedGovernor,seatBelts,wipers,windShield,windows,tires,brakes;
    
    private LocalDate registrationDate;

    
    private LocalDate inspectionDate;

    
    private Vehicle vehicle;
}
