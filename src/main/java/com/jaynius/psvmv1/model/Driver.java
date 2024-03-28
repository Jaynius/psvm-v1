package com.jaynius.psvmv1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Driver {
    @Id
    private String idnumber;
    private String name,contact,email;

    @OneToOne
    @JoinColumn(name="vehicle_Registration")
    private Vehicle vehicle;
}
