package com.jaynius.psvmv1.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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


    @OneToOne(mappedBy = "vehicle",cascade = CascadeType.ALL)
    @JsonIgnore
    private Conductor conductor;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Inspection> inspections=new ArrayList<>();

    @ManyToMany(mappedBy = "vehicles",cascade = CascadeType.ALL)
    private Set<Users> users=new HashSet<>();

    @ManyToMany(mappedBy = "vehicle",cascade = CascadeType.ALL)
    private Set<VehicleOwners> owners=new HashSet<>();

    
    


}
