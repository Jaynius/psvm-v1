package com.jaynius.psvmv1.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

@Getter
public class Driver {
    @Id
    private String idnumber;
    private String name,contact,email, password;

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setContact(String contact) {
        this.contact = contact;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    @OneToOne
    @JoinColumn(name="vehicle_Registration")
    private Vehicle vehicle;

    
    public void setPassword(){
         PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }
}
