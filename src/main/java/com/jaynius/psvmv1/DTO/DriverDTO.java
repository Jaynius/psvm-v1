package com.jaynius.psvmv1.DTO;

import com.jaynius.psvmv1.model.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DriverDTO {

    private String idnumber;
    private String name,contact,email, password;
    private Vehicle vehicle;
}
