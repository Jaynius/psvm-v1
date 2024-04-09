package com.jaynius.psvmv1.DTO;

import java.time.LocalDate;

import com.jaynius.psvmv1.model.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrackerDTO {

    private String serialNumber;
    private double speed;
    private String gpsCordinates;
    private LocalDate updatedAt;
    private Vehicle vehicle;
}
