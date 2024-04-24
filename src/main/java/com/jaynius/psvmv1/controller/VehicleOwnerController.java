package com.jaynius.psvmv1.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.model.VehicleOwners;
import com.jaynius.psvmv1.service.VehicleOwnerService;

@RestController
@RequestMapping("/owners")
public class VehicleOwnerController {
    private final VehicleOwnerService service;

    public VehicleOwnerController(VehicleOwnerService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public ResponseEntity<VehicleOwners> addOwner(@RequestBody VehicleOwners owner){
        return service.addOwner(owner);
    }

    @GetMapping("/{idNumber}")
    public ResponseEntity<VehicleOwners> findOwnersById(@PathVariable String idNumber){
        return service.findOwnersById(idNumber);
    }

    @PutMapping("/update/{idnumber}")
    public ResponseEntity<VehicleOwners> updateOwnersById(@RequestBody VehicleOwners owner,@PathVariable String idNumber){
        return service.updateOwnersById(owner, idNumber);
    }

    @GetMapping("/vehicle/{registrationNumber}")
    public ResponseEntity<Set<VehicleOwners>> findOwnersByVehicleId(@PathVariable String registrationNumber){
        return service.findOwnersByVehicleId(registrationNumber);
    }
    @DeleteMapping("/delete/{idnumber}")
    public void deleteOwnersById(@PathVariable String idNumber){
        service.deleteOwnersById(idNumber);
    } 
    @GetMapping("/all")
    public List<VehicleOwners> findallOwners(){
        return service.findAllOwners();
    }

    @PatchMapping("/assign/{idNumber}/vehicle/{registrationNumber}")
    public ResponseEntity<VehicleOwners> assignOwnerToVehicle(@PathVariable String idNumber, @PathVariable String registrationNumber){
        return service.assignOwnerToVehicle(idNumber, registrationNumber);
    }

}
