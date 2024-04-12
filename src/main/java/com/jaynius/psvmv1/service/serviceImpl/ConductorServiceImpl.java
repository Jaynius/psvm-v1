package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final VehicleRepository vRepository;


    @Override
   public  String  addConductor(Conductor conductor) {
        // repository.save(conductor);
        // return "Conductor added successfully";
      Conductor newcConductor=new Conductor();
        newcConductor.setIdNumber(conductor.getIdNumber());
        newcConductor.setName(conductor.getName());
        newcConductor.setContacts(conductor.getContacts()); 
        newcConductor.setEmail(conductor.getEmail());
        newcConductor.setPassword(passwordEncoder.encode(conductor.getPassword()));
        repository.save(newcConductor);
        return "Conductor added successfully";
      
    }

    @Override
    public ResponseEntity<Conductor> findConductorById(String idNumber) {
     
        Optional<Conductor> existtingConductor=repository.findById(idNumber);
        if (existtingConductor.isPresent()) {

          Conductor conductor=existtingConductor.get();
          conductor.setPassword(null);
            return new ResponseEntity<>(conductor,HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Conductor> updateConductorById(String idNumber, Conductor conductor) {
  
        Optional<Conductor> existingConductor=repository.findById(idNumber);
        if (existingConductor.isPresent()) {
            Conductor conductorToUpdate=existingConductor.get();
            if(conductor.getIdNumber()!=null){
                conductorToUpdate.setIdNumber(conductor.getIdNumber());
            }
            if(conductor.getName()!=null){
                conductorToUpdate.setName(conductor.getName());
            }
            if(conductor.getContacts()!=null){
                conductorToUpdate.setContacts(conductor.getContacts());
            }
            if(conductor.getEmail()!=null){
                conductorToUpdate.setEmail(conductor.getEmail());
            }
            if(conductor.getVehicle()!=null){
                conductorToUpdate.setVehicle(conductor.getVehicle());
            }
    
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

    @Override
    public ResponseEntity<Conductor> assigConductorToVehicle( String idNumber, String registrationNumber) {
        Optional<Conductor> optionalConductor=repository.findById(idNumber);
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalConductor.isPresent() && optionalVehicle.isPresent()) {
            Conductor conductor=optionalConductor.get();
            Vehicle vehicle=optionalVehicle.get();
            conductor.setVehicle(vehicle);
            repository.save(conductor);
            return new ResponseEntity<>(HttpStatus.OK);
           
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }}

