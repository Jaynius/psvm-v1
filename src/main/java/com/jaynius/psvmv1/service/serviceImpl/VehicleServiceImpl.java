package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Vehicle;
import com.jaynius.psvmv1.model.VehicleOwners;
import com.jaynius.psvmv1.repository.VehicleOwnerRepository;
import com.jaynius.psvmv1.repository.VehicleRepository;
import com.jaynius.psvmv1.service.VehicleOwnerService;
import com.jaynius.psvmv1.service.Vehicleservice;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VehicleServiceImpl implements Vehicleservice{
    
    @Autowired
    private final VehicleRepository repository;

    @Autowired
    private final VehicleOwnerRepository vOwnerRepository;

   

   

    @Override
    public ResponseEntity<Vehicle> createVehicle(Vehicle vehicle) {
     repository.save(vehicle);
     return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Vehicle> findVehicleByRegistration(String registrationNumber) {
        Optional<Vehicle> vehicle=repository.findById(registrationNumber);
        if (vehicle.isPresent()) {
            return new ResponseEntity<>(vehicle.get(),HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Vehicle> updateVehicleByRegistration(Vehicle vehicle, String registrationNumber) {
        Optional<Vehicle> existingVehicle=repository.findById(registrationNumber);
        if (existingVehicle.isPresent()) {
            Vehicle updatedVehicle=existingVehicle.get();
            updatedVehicle.setBrand(vehicle.getBrand());
            updatedVehicle.setColor(vehicle.getColor());
            updatedVehicle.setConductor(vehicle.getConductor());
            updatedVehicle.setDriver(vehicle.getDriver());
            updatedVehicle.setInspections(vehicle.getInspections());
            updatedVehicle.setModel(vehicle.getModel());
            updatedVehicle.setOwners(vehicle.getOwners());       
            updatedVehicle.setRegistrationNumber(vehicle.getRegistrationNumber());     
            updatedVehicle.setSeatCapacity(vehicle.getSeatCapacity());
            updatedVehicle.setTracker(vehicle.getTracker());
            updatedVehicle.setUsers(vehicle.getUsers());
            repository.save(updatedVehicle);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Vehicle> deleteVehicleByRegistration(String registrationNumber) {
        Optional<Vehicle> vehicle=repository.findById(registrationNumber);
        if (vehicle.isPresent()) {
            repository.deleteById(registrationNumber);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Vehicle>> findAllVehicles() {
       List<Vehicle> vehicleList=new ArrayList<>();
       repository.findAll().forEach(vehicleList::add);
       if (vehicleList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
       }
       return new ResponseEntity<>(vehicleList,HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Set<Vehicle>> findVehicleByOwnerId(String idNumber) {
       Optional<VehicleOwners> optionalOwner=vOwnerRepository.findById(idNumber);
       if (optionalOwner.isPresent()) {
        VehicleOwners owner=optionalOwner.get();
        Set<Vehicle> vehicles=owner.getVehicle();
        return new ResponseEntity<>(vehicles,HttpStatus.FOUND);

        
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
