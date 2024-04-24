package com.jaynius.psvmv1.model;

import java.util.HashSet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
 @Data
public class Vehicle {
    @Id
    private String registrationNumber;
    private String brand, model, color;
    private Integer seatCapacity;

    @OneToOne(mappedBy = "vehicle",cascade = CascadeType.ALL)
    private Tracker tracker;

    @OneToOne(mappedBy = "vehicle",cascade = CascadeType.ALL)
    @JsonIgnore
    private Drivers driver;

    @OneToMany(mappedBy = "vehicles",cascade = CascadeType.ALL)
    private Set<Inspector> inspectors = new HashSet<>();
    
    @OneToOne(mappedBy = "vehicle",cascade = CascadeType.ALL)
    private Conductor conductor;

    @OneToMany(mappedBy = "vehicles", cascade = CascadeType.ALL)
    private Set<Users> users = new HashSet<>();

    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.ALL)
    private Set<Inspection> inspections = new HashSet<>();

    @ManyToMany(mappedBy = "vehicles",cascade = CascadeType.ALL)
    private Set<VehicleOwners> owners = new HashSet<>();


}
