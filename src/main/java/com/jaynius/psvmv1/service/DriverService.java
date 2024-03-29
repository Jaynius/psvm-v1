package com.jaynius.psvmv1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.Driver;

@Service
public interface DriverService {
    ResponseEntity<Driver> addDriver(Driver driver);
    ResponseEntity<Driver> findDriverById(String idNumber);
    ResponseEntity<Driver> updateDriverById(Driver driver,String idNumber);
    ResponseEntity<Driver> deleteDriverById(String idNumber);
    ResponseEntity<List<Driver>> findAllDrivers();
    ResponseEntity<Driver> findDriverByVehicle(String registrationNumber);

}
