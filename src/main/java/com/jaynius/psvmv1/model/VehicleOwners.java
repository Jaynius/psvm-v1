package com.jaynius.psvmv1.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class VehicleOwners {
    private String idNumber;
    private String logBookNumber,name,contacts,email;

    private Vehicle vehicle;
    
}
