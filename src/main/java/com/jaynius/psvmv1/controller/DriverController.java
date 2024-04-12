package com.jaynius.psvmv1.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.model.Driver;
import com.jaynius.psvmv1.service.DriverService;

@RestController
public class DriverController {
    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @PostMapping("/drivers/add")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver newDriver){
        return service.addDriver(newDriver);
    }

    @GetMapping("/drivers/driver/{idNumber}")
    public ResponseEntity<Driver> findDriverById(@PathVariable String idNumber){
        return service.findDriverById(idNumber);
    }

    @PutMapping("/drivers/update/{idnumber}")
    public ResponseEntity<Driver> updateDriverById(@RequestBody Driver driver,@PathVariable String idNumber){
        return service.updateDriverById(driver, idNumber);
    }
    @GetMapping("/drivers/driver/vehicle/{registrationnumber}")
    public ResponseEntity<Driver> findDriversByVehicleid(@PathVariable String registrationNumber){
        return service.findDriverByVehicle(registrationNumber);
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> allDrivers(){
        return service.findAllDrivers();
    }

    @DeleteMapping("drivers/delete/{idNumber}")
    public ResponseEntity<Driver> deleteDriver(@PathVariable String idNumber){
        return service.deleteDriverById(idNumber);
    }

}
