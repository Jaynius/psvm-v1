package com.jaynius.psvmv1.DTO;

import com.jaynius.psvmv1.model.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ConductorDTO {

    private String idNumber;
    private String name, contacts,email, password;
    private Vehicle vehicle;
}
