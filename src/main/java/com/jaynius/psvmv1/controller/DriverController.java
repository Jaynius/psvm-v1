package com.jaynius.psvmv1.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.model.Drivers;
import com.jaynius.psvmv1.service.DriverService;

@RestController
@RequestMapping("/drivers")
@CrossOrigin
public class DriverController {
    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String addDriver(@RequestBody Drivers newDriver){
        return service.addDriver(newDriver);
    }

    @GetMapping("/{idNumber}")
    public ResponseEntity<Drivers> findDriverById(@PathVariable String idNumber){
        return service.findDriverById(idNumber);
    }

    @PatchMapping("/update/{idNumber}")
    public ResponseEntity<Drivers> updateDriverById(@RequestBody Drivers driver,@PathVariable String idNumber){
        return service.updateDriverById(driver, idNumber);
    }
    @GetMapping("/vehicle/{registrationNumber}")
    public ResponseEntity<Drivers> findDriversByVehicleId(@PathVariable String registrationNumber){
        return service.findDriverByVehicle(registrationNumber);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Drivers>> allDrivers(){
        return service.findAllDrivers();
    }

    @DeleteMapping("/delete/{idNumber}")
    public ResponseEntity<?> deleteDriver(@PathVariable String idNumber){
        return service.deleteDriverById(idNumber);
    }

    @GetMapping("/count")
    public Integer countOfDrivers(){
        return service.countOfDrivers();
    }

    @PatchMapping("/assign/{idNumber}/vehicle/{registrationNumber}")
    public ResponseEntity<Drivers> assignDriverToVehicle(@PathVariable String idNumber, @PathVariable String registrationNumber){
        return service.assignDriverToVehicle(idNumber, registrationNumber);
    }

    

}
