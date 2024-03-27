package com.jaynius.psvmv1.model;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Tracker {
    @Id
    private String serialNumber;
    private double speed;
    private String gpsCordinates;
    @UpdateTimestamp
    private LocalDate updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

}
