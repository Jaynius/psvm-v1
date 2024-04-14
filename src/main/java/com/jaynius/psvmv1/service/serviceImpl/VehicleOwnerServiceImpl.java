package com.jaynius.psvmv1.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Vehicle;
import com.jaynius.psvmv1.model.VehicleOwners;
import com.jaynius.psvmv1.repository.VehicleOwnerRepository;
import com.jaynius.psvmv1.repository.VehicleRepository;
import com.jaynius.psvmv1.service.VehicleOwnerService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VehicleOwnerServiceImpl implements VehicleOwnerService{

    @Autowired
    private final VehicleOwnerRepository repository;

    @Autowired 
    private final VehicleRepository vRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    

   

    @Override
    public ResponseEntity<VehicleOwners> addOwner(VehicleOwners owner) {
        VehicleOwners newOwner=new VehicleOwners();
        newOwner.setIdNumber(owner.getIdNumber());
        newOwner.setName(owner.getName());
        newOwner.setContacts(owner.getContacts());
        newOwner.setEmail(owner.getEmail());
        newOwner.setLogBookNumber(owner.getLogBookNumber());
        newOwner.setVehicle(owner.getVehicle());
        newOwner.setPassword(passwordEncoder.encode(owner.getPassword()));
    repository.save(owner);
    return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<VehicleOwners> findOwnersById(String idNumber) {
        @SuppressWarnings("null")
        Optional<VehicleOwners> owner=repository.findById(idNumber);
        if (owner.isPresent()) {
            return new ResponseEntity<>(owner.get(),HttpStatus.FOUND);

            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<VehicleOwners> updateOwnersById(VehicleOwners owner, String idNumber) {
        @SuppressWarnings("null")
        Optional<VehicleOwners> existingOwner=repository.findById(idNumber);
        if (existingOwner.isPresent()) {
            VehicleOwners updatedOwner=existingOwner.get();
            updatedOwner.setIdNumber(owner.getIdNumber());
            updatedOwner.setName(owner.getName());
            updatedOwner.setContacts(owner.getContacts());
            updatedOwner.setEmail(owner.getEmail());
            updatedOwner.setLogBookNumber(owner.getLogBookNumber());
            updatedOwner.setVehicle(owner.getVehicle());
            repository.save(updatedOwner);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<VehicleOwners> findOwnersByVehicleId(String registrationNumber) {
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle=optionalVehicle.get();
            VehicleOwners vehicleOwners=vehicle.getOwners();
            return new ResponseEntity<>(vehicleOwners,HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @Override
    public void deleteOwnersById(String idNumber) {
        
       repository.deleteById(idNumber);
    }

    
    @Override
    public List<VehicleOwners>findAllOwners() {
       return repository.findAll();
   
    }

    @Override
    public ResponseEntity<VehicleOwners> assignOwnerToVehicle(String idNumber, String registrationNumber) {
        Optional<VehicleOwners> optionalOwner=repository.findById(idNumber);
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalOwner.isPresent() && optionalVehicle.isPresent()) {
            VehicleOwners owner=optionalOwner.get();
            Vehicle vehicle=optionalVehicle.get();
            owner.setVehicle(vehicle);
            repository.save(owner);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
