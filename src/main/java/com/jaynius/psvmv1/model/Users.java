package com.jaynius.psvmv1.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.CascadeType;
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
@Setter
@Getter
@Data
public class Users {
    @Id
    private String idNumber;
    private String name,contacts,email,password;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "userVehicle",
        joinColumns={@JoinColumn(name = "userid")},
        inverseJoinColumns = {@JoinColumn(name="vehicle_registration")}
    )
    private Set<Vehicle> vehicles=new HashSet<>();
     public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
        
    }

    
}
