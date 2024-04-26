package com.jaynius.psvmv1.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.NaturalId;

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
    private String logBookNumber,name,contacts;

    @NaturalId(mutable = true)
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
        name = "vehicles_owners",
        joinColumns={@JoinColumn(name = "ownerId")},
        inverseJoinColumns = {@JoinColumn(name="vehicle_id")}
    )
    private Set<Vehicle> vehicles=new HashSet<>();


}
