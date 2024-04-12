package com.jaynius.psvmv1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.DTO.ConductorDTO;
import com.jaynius.psvmv1.model.Conductor;
import com.jaynius.psvmv1.model.Vehicle;

@Service
public interface ConductorService {
         String addConductor(Conductor conductor);
         ResponseEntity<Conductor> findConductorById(String idNumber);
         ResponseEntity<Conductor> updateConductorById(String idNumber,Conductor conductor);
         ResponseEntity<Conductor> deleteConductorById(String idNumber);
         ResponseEntity<Conductor> findConductorbyVehicle(String registrationNumber);
         ResponseEntity<List<Conductor>> findAllConductors();
         ResponseEntity<Conductor> assigConductorToVehicle(String idNumber, String registrationNumber);



}
