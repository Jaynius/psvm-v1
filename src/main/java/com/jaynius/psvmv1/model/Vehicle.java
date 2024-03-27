package com.jaynius.psvmv1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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

    @OneToOne(mappedBy = "vehicle")
    private Tracker tracker;

    @OneToOne(mappedBy = "vehicle")
    private Driver driver;

    @OneToOne(mappedBy = "vehicle")
    private Conductor conductor;

    @OneToMany(fetch = FetchType.LAZY)
    private Inspection inspection;
    


}
