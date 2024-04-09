package com.jaynius.psvmv1.DTO;

import java.util.HashSet;
import java.util.Set;

import com.jaynius.psvmv1.model.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class VehicleOwnerDTO {
    private String idNumber;
    private String logBookNumber,name,contacts,email, password;
    private Set<Vehicle> vehicle=new HashSet<>();


}
