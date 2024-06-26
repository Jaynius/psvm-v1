package com.jaynius.psvmv1.model;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Setter
@Getter
@Data
public class Conductor {
    @Id
    private String idNumber;
    private String name, contacts;
    
    @NaturalId(mutable = true)
    private String email;
    private String password;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "vehicle_registration")
    private Vehicle vehicle;

    
}
