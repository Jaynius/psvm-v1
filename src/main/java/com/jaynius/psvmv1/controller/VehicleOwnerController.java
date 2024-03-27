package com.jaynius.psvmv1.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.model.VehicleOwners;
import com.jaynius.psvmv1.service.VehicleOwnerService;

@RestController
public class VehicleOwnerController {
    private final VehicleOwnerService service;

    public VehicleOwnerController(VehicleOwnerService service) {
        this.service = service;
    }
    @PostMapping("/owners/add")
    public ResponseEntity<VehicleOwners> addOwner(@RequestBody VehicleOwners owner){
        return service.addOwner(owner);
    }

    @GetMapping("/owners/owner/{idNumber}")
    public ResponseEntity<VehicleOwners> findOwnersById(@PathVariable String idNumber){
        return service.deleteOwnersById(idNumber);
    }

    @PutMapping("/owner/update/{idnumber}")
    public ResponseEntity<VehicleOwners> updateOwnersById(@RequestBody VehicleOwners owner,@PathVariable String idNumber){
        return service.updateOwnersById(owner, idNumber);
    }

    @GetMapping("/owners/vehicle/{registrationNumber}")
    public ResponseEntity<List<VehicleOwners>> findOwnersByVehicleId(@PathVariable String registrationNumber){
        return service.findOwnersByVehicleId(registrationNumber);
    }
    @DeleteMapping("/owners/delete/{idnumber}")
    public ResponseEntity<VehicleOwners> deleteOwnersById(@PathVariable String idNumber){
        return service.deleteOwnersById(idNumber);
    }
    @GetMapping("/owners")
    public ResponseEntity<List<VehicleOwners>> findAllOwners(){
        return service.findAllOwners();
    }

}
