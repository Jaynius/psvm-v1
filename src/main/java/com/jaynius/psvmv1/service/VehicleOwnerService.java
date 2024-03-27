package com.jaynius.psvmv1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.VehicleOwners;

@Service
public interface VehicleOwnerService {
    ResponseEntity<VehicleOwners> addOwner(VehicleOwners owner);
    ResponseEntity<VehicleOwners> findOwnersById(String idNumber);
    ResponseEntity<VehicleOwners> updateOwnersById(VehicleOwners owner,String idNumber);
    ResponseEntity<List<VehicleOwners>> findOwnersByVehicleId(String registrationNumber);
    ResponseEntity<VehicleOwners> deleteOwnersById(String idNumber);
    ResponseEntity<List<VehicleOwners>> findAllOwners();


}
