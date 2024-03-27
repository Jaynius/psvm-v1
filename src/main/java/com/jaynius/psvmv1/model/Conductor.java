package com.jaynius.psvmv1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
    private String name, contacts,email;

    @OneToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    
}
