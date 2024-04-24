package com.jaynius.psvmv1.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Users {
    @Id
    private String idNumber;
    private String name,contacts,email,password;

    @ManyToMany
    @JoinTable(
        name = "user_vehicles",
        joinColumns={@JoinColumn(name = "userId")},
        inverseJoinColumns = {@JoinColumn(name="vehicle_id")}
    )
    private Set<Vehicle> vehicles=new HashSet<>();

   
     

    
}
