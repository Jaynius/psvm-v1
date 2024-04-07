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
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inspector {
    @Id
    private String idNumber;
    private String name,email,contact,password;

       @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "inspector_inspections",
        joinColumns={@JoinColumn(name = "inspectorId")},
        inverseJoinColumns = {@JoinColumn(name="inpsection_id")}
    )
    private Set<Inspection> inspections=new HashSet<>();

     public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
        
    }

}
