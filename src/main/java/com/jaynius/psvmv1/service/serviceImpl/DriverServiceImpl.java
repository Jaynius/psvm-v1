package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Drivers;
import com.jaynius.psvmv1.model.Vehicle;
import com.jaynius.psvmv1.repository.DriverRepository;
import com.jaynius.psvmv1.repository.VehicleRepository;
import com.jaynius.psvmv1.service.DriverService;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
@AllArgsConstructor

public class DriverServiceImpl implements DriverService{
    @Autowired
    private final DriverRepository repository;

    @Autowired
    private final VehicleRepository vRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addDriver(Drivers driver) {
        Drivers newDriver=new Drivers();
        newDriver.setIdNumber(driver.getIdNumber());
        newDriver.setName(driver.getName());
        newDriver.setContacts(driver.getContacts());
        newDriver.setEmail(driver.getEmail());
        newDriver.setPassword(passwordEncoder.encode(driver.getPassword()));

        repository.save(newDriver);
        return "Driver added successfully";
    }

    @Override
    public ResponseEntity<Drivers> findDriverById(String idNumber) {
      
        Optional<Drivers> driver=repository.findById(idNumber);
        if (driver.isPresent()) {
            Drivers returnDriver=driver.get();
            returnDriver.setPassword(null);
            return new ResponseEntity<>(returnDriver,HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Drivers> updateDriverById(Drivers driver, String idNumber) {
 
    Optional<Drivers> existingDriver=repository.findById(idNumber);
      if (existingDriver.isPresent()) {
        Drivers updatedDriver=existingDriver.get();
        if(driver.getIdNumber()!=null){
        updatedDriver.setIdNumber(driver.getIdNumber());
    }
        if (driver.getName()!=null) {
            updatedDriver.setName(driver.getName());   
        }
        if (driver.getEmail()!=null) {
            updatedDriver.setEmail(driver.getEmail()); 
        }
        if (driver.getContacts()!=null) {
            updatedDriver.setContacts(driver.getContacts());
        }
        if (driver.getVehicle()!=null) {
            updatedDriver.setVehicle(driver.getVehicle());
        }
       
        repository.save(updatedDriver);
        return new ResponseEntity<>(HttpStatus.OK);
        
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Drivers> deleteDriverById(String idNumber) {
        repository.deleteById(idNumber);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }

    @Override
    public ResponseEntity<List<Drivers>> findAllDrivers() {
  
        List<Drivers> driverList=new ArrayList<>();
        repository.findAll()
                  .forEach(driverList::add);
        if (driverList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        }
        return new ResponseEntity<>(driverList,HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Drivers> findDriverByVehicle(String registrationNumber) {
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle=optionalVehicle.get();
            Drivers driver=vehicle.getDriver();
            driver.setPassword(null);
            return new ResponseEntity<>(driver,HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
    }

    @Override
    public Integer countOfDrivers() {
        int count=0;
        List<Drivers> driverList=new ArrayList<>();
        repository.findAll().forEach(driverList::add);
        if (driverList.isEmpty()) {
            return null;

        }
        count=driverList.size();
        return count;

    }

    @Override
    public ResponseEntity<Drivers> assignDriverToVehicle(String idNumber, String registrationNumber) {
        Optional<Drivers> optionalDriver=repository.findById(idNumber);
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalDriver.isPresent() && optionalVehicle.isPresent()) {
            Drivers driver=optionalDriver.get();
            Vehicle vehicle=optionalVehicle.get();
            driver.setVehicle(vehicle);
            repository.save(driver);
            return new ResponseEntity<>(HttpStatus.OK);
           
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  

    

}
