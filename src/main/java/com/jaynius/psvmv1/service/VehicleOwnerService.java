package com.jaynius.psvmv1.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.VehicleOwners;

@Service
public interface VehicleOwnerService {
    ResponseEntity<VehicleOwners> addOwner(VehicleOwners owner);
    ResponseEntity<VehicleOwners> findOwnersById(String idNumber);
    ResponseEntity<VehicleOwners> updateOwnersById(VehicleOwners owner,String idNumber);
    ResponseEntity<VehicleOwners> findOwnersByVehicleId(String registrationNumber);
      void deleteOwnersById(String idNumber);
    List<VehicleOwners> findAllOwners();
    ResponseEntity<VehicleOwners> assignOwnerToVehicle(String idNumber, String registrationNumber);


}
