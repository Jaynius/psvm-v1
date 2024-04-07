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

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VehicleOwnerServiceImpl implements VehicleOwnerService{

    @Autowired
    private final VehicleOwnerRepository repository;

    @Autowired 
    private final VehicleRepository vRepository;

    

   

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<VehicleOwners> addOwner(VehicleOwners owner) {
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
    public ResponseEntity<Set<VehicleOwners>> findOwnersByVehicleId(String registrationNumber) {
        @SuppressWarnings("null")
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle=optionalVehicle.get();
            Set<VehicleOwners> vehicleOwners=vehicle.getOwners();
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
    //    repository.findAll().forEach(ownerList::add);
    //    if (ownerList.isEmpty()) {
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    //    }
    //    return new ResponseEntity<>(ownerList,HttpStatus.FOUND);
    }

//     @Override
// public ResponseEntity<List<VehicleOwners>> findAllOwners() {
//     try {
//         List<VehicleOwners> ownerList = repository.findAll();
//         if (ownerList.isEmpty()) {
//             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//         }
//         return new ResponseEntity<>(ownerList, HttpStatus.FOUND);
//     } catch (Exception e) {
//         // Log the exception for debugging
//         e.printStackTrace();
//         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }


}
