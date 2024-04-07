package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Conductor;
import com.jaynius.psvmv1.model.Vehicle;
import com.jaynius.psvmv1.repository.ConductorRepository;
import com.jaynius.psvmv1.repository.VehicleRepository;
import com.jaynius.psvmv1.service.ConductorService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private final ConductorRepository repository;

    @Autowired
    private final VehicleRepository vRepository;

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<Conductor> addConductor(Conductor conductor) {
      repository.save(conductor);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Conductor> findConductorById(String idNumber) {
        @SuppressWarnings("null")
        Optional<Conductor> existtingConductor=repository.findById(idNumber);
        if (existtingConductor.isPresent()) {
            return new ResponseEntity<>(existtingConductor.get(),HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Conductor> updateConductorById(String idNumber, Conductor conductor) {
        @SuppressWarnings("null")
        Optional<Conductor> existingConductor=repository.findById(idNumber);
        if (existingConductor.isPresent()) {
            Conductor conductorToUpdate=existingConductor.get();
            conductorToUpdate.setIdNumber(conductor.getIdNumber());
            conductorToUpdate.setName(conductor.getName());
            conductorToUpdate.setContacts(conductor.getContacts());
            conductorToUpdate.setEmail(conductor.getEmail());
            conductorToUpdate.setVehicle(conductor.getVehicle());
            repository.save(conductorToUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<Conductor> deleteConductorById(String idNumber) {
        repository.deleteById(idNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Conductor> findConductorbyVehicle(String registrationNumber) {
      @SuppressWarnings("null")
    Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
      if (optionalVehicle.isPresent()) {
        Vehicle vehicle=optionalVehicle.get();
        Conductor conductor=vehicle.getConductor();
        return new ResponseEntity<>(conductor,HttpStatus.FOUND);

        
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<List<Conductor>> findAllConductors() {
        List<Conductor> conductorList=new ArrayList<>();
        repository.findAll().forEach(conductorList::add);
        if (conductorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        }
        return new ResponseEntity<>(conductorList,HttpStatus.FOUND);
    }

}
