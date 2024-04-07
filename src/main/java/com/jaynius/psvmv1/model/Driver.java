package com.jaynius.psvmv1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Driver {
    @Id
    private String idnumber;
    private String name,contact,email, password;

    @OneToOne
    @JoinColumn(name="vehicle_Registration")
    private Vehicle vehicle;

    public void setPassWord(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
}
