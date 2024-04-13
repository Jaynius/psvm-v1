package com.jaynius.psvmv1.DTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jaynius.psvmv1.model.Conductor;
import com.jaynius.psvmv1.model.Drivers;
import com.jaynius.psvmv1.model.Inspection;
import com.jaynius.psvmv1.model.Tracker;
import com.jaynius.psvmv1.model.Users;
import com.jaynius.psvmv1.model.VehicleOwners;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VehicleDTO {
     private String registrationNumber;
    private String brand, model, color;
    private Integer seatCapacity;

    private Tracker tracker;

    private Drivers driver;

    private Conductor conductor;

    private List<Inspection> inspections=new ArrayList<>();

    private Set<Users> users=new HashSet<>();
    private Set<VehicleOwners> owners=new HashSet<>();

}
