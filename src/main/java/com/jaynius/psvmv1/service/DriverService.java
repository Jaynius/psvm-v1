package com.jaynius.psvmv1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.Drivers;

@Service
public interface DriverService {
    String addDriver(Drivers driver);
    ResponseEntity<Drivers> findDriverById(String idNumber);
    ResponseEntity<Drivers> updateDriverById(Drivers driver,String idNumber);
    ResponseEntity<?> deleteDriverById(String idNumber);
    ResponseEntity<List<Drivers>> findAllDrivers();
    ResponseEntity<Drivers> findDriverByVehicle(String registrationNumber);
    Integer countOfDrivers();
    ResponseEntity<Drivers> assignDriverToVehicle(String idNumber, String registrationNumber);
    
}
