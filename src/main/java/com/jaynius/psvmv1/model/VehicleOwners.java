package com.jaynius.psvmv1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    @Id
    private String idNumber;
    private String logBookNumber,name,contacts,email;
    private String password;

   @OneToOne
    @JoinColumn(name = "vehicle_registration")
    private Vehicle vehicle;


}
