package com.jaynius.psvmv1.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(name = "owner_vehicle",
        joinColumns = {@JoinColumn(name="owner_id")},
        inverseJoinColumns = {@JoinColumn(name="vehicle_registration")}
    )
    private Set<Vehicle> vehicle=new HashSet<>();
    
}
