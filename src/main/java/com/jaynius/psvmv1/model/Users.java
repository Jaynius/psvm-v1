package com.jaynius.psvmv1.model;

import jakarta.persistence.Entity;
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
    private String idNumber;
    private String name,contacts,email;

    private Vehicle vehicle;

    
}
