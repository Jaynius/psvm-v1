package com.jaynius.psvmv1.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.model.Vehicle;
import com.jaynius.psvmv1.service.Vehicleservice;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin
public class VehicleController {

    private final Vehicleservice service;

    public VehicleController(Vehicleservice service) {
        this.service = service;
    }
    @PostMapping("/add")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        return service.createVehicle(vehicle);
    }
    @GetMapping("/vehicles/vehicle/{registrationNumber}")
    public ResponseEntity<Vehicle> findVehicleByRegistration(@PathVariable String registrationNumber){
        return service.findVehicleByRegistration(registrationNumber);
    }

    @GetMapping("/vehicle/update/{registrationNumber}")
    public ResponseEntity<Vehicle> updateVehicleByRegistration(@RequestBody Vehicle vehicle,@PathVariable String registrationNumber){
        return service.updateVehicleByRegistration(vehicle, registrationNumber);
    }

    @DeleteMapping("/vehicle/delete/{registrationNumber}")
    public ResponseEntity<Vehicle> deleteVehicleByRegistration(@PathVariable String registrationNumber){
        return service.deleteVehicleByRegistration(registrationNumber);
    }

    @GetMapping("/all")
    public List<Vehicle> findAllVehicles(){
        return service.findAllVehicles();
    }

    @GetMapping("/vehicle/owner/{idNumber}")
    public ResponseEntity<Set<Vehicle>> findVehicleByOwnerId(String idNumber){
        return service.findVehicleByOwnerId(idNumber);
    }

    @GetMapping("/count")
    public Integer countOfVehicles(){
        return service.countOfVehicles();
    }

}
