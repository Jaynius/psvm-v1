package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Driver;
import com.jaynius.psvmv1.model.Vehicle;
import com.jaynius.psvmv1.repository.DriverRepository;
import com.jaynius.psvmv1.repository.VehicleRepository;
import com.jaynius.psvmv1.service.DriverService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DriverServiceImpl implements DriverService{
    @Autowired
    private final DriverRepository repository;

    @Autowired
    private final VehicleRepository vRepository;

   

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<Driver> addDriver(Driver driver) {
       repository.save(driver);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Driver> findDriverById(String idNumber) {
        @SuppressWarnings("null")
        Optional<Driver> driver=repository.findById(idNumber);
        if (driver.isPresent()) {
            return new ResponseEntity<>(driver.get(),HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Driver> updateDriverById(Driver driver, String idNumber) {
      @SuppressWarnings("null")
    Optional<Driver> existingDriver=repository.findById(idNumber);
      if (existingDriver.isPresent()) {
        Driver updatedDriver=existingDriver.get();
        updatedDriver.setIdnumber(driver.getIdnumber());
        updatedDriver.setName(driver.getName());
        updatedDriver.setEmail(driver.getEmail());
        updatedDriver.setContact(driver.getContact());
        updatedDriver.setVehicle(driver.getVehicle());
        repository.save(updatedDriver);
        return new ResponseEntity<>(HttpStatus.OK);
        
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<Driver> deleteDriverById(String idNumber) {
        @SuppressWarnings("null")
        Optional<Driver> existingDriver=repository.findById(idNumber);
        if (existingDriver.isPresent()) {
            repository.deleteById(idNumber);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Driver>> findAllDrivers() {
  
        List<Driver> driverList=new ArrayList<>();
        repository.findAll().forEach(driverList::add);
        if (driverList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        }
        return new ResponseEntity<>(driverList,HttpStatus.FOUND);

    }

    @Override
    public ResponseEntity<Driver> findDriverByVehicle(String registrationNumber) {
        @SuppressWarnings("null")
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle=optionalVehicle.get();
            Driver driver=vehicle.getDriver();
            return new ResponseEntity<>(driver,HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
    }

}
