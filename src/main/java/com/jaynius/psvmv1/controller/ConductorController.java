package com.jaynius.psvmv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.DTO.ConductorDTO;
import com.jaynius.psvmv1.model.Conductor;
import com.jaynius.psvmv1.service.ConductorService;


@RestController
@RequestMapping("v1/conductors")
public class ConductorController {
    @Autowired

    private final ConductorService service;

    public ConductorController(ConductorService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public String addConductors(@RequestBody Conductor conductor){
        return service.addConductor(conductor);
    }

    @GetMapping("/conductors/conductor/{idnumber}")
    public ResponseEntity<Conductor> findconductorById(@PathVariable String idNumber){
        return service.findConductorById(idNumber);
    }

    @PostMapping("/conductors/conductor/update/{idnumber}")
    public ResponseEntity<Conductor> updateConductorById(@RequestBody Conductor conductor,@PathVariable String idNumber){
        return service.updateConductorById(idNumber, conductor);
    }

    @GetMapping("/conductors/{vehicle}")
    public ResponseEntity<Conductor> findconductorByVehicle(@PathVariable String registrationNumber){
        return service.findConductorbyVehicle(registrationNumber);
    }
    @GetMapping("/conductors/all")
    public ResponseEntity<List<Conductor>> allconductors(){
        return service.findAllConductors();
    }

    @DeleteMapping("/conductors/delete/{idnumber}")
    public ResponseEntity<Conductor> deleteConductorById(@PathVariable String idNumber){
        return service.deleteConductorById(idNumber);
    }
   
    

}
