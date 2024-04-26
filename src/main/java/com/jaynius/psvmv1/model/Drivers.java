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
public class Drivers {
    @Id
    private String idNumber;
    private String name, contacts;

    @NaturalId(mutable = true)
    private String  email;
    private String password;

    @OneToOne
    @JoinColumn(name="vehicle_Registration")
    @JsonBackReference
    private Vehicle vehicle;

    // public void setPassword(Object object) {
    //     PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //     this.password = passwordEncoder.encode(password);
    // }


    
}
