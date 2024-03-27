package com.jaynius.psvmv1.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.Vehicle;

@Service
public interface Vehicleservice {
     ResponseEntity<Vehicle> createVehicle(Vehicle vehicle);
     ResponseEntity<Vehicle> findVehicleByRegistration(String registrationNumber);
     ResponseEntity<Vehicle> updateVehicleByRegistration(Vehicle vehicle,String registrationNumber);
     ResponseEntity<Vehicle> deleteVehicleByRegistration(String registrationNumber);
     ResponseEntity<List<Vehicle>> findAllVehicles();
    
     



    

}
