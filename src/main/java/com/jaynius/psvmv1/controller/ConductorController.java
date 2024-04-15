package com.jaynius.psvmv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.model.Conductor;
import com.jaynius.psvmv1.service.ConductorService;


@RestController
@RequestMapping("/conductors")
@CrossOrigin
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

    @GetMapping("/conductor/{idNumber}")
    public ResponseEntity<Conductor> findconductorById(@PathVariable String idNumber){
        return service.findConductorById(idNumber);
    }

    @PatchMapping("/update/{idNumber}")
    public ResponseEntity<Conductor> updateConductorById(@RequestBody Conductor conductor,@PathVariable String idNumber){
        return service.updateConductorById(idNumber, conductor);
    }

    @GetMapping("/{vehicle}")
    public ResponseEntity<Conductor> findconductorByVehicle(@PathVariable String registrationNumber){
        return service.findConductorbyVehicle(registrationNumber);
    }
    @PatchMapping("/assign/{idNumber}/vehicle/{registrationNumber}")
    public ResponseEntity<Conductor> assignConductorToVehicle(@PathVariable String idNumber, @PathVariable String registrationNumber){
        return service.assigConductorToVehicle(idNumber, registrationNumber);
    }
    
    @GetMapping("vehicle/{registrationNumber}")
    public ResponseEntity<Conductor> findConductorByVehicle(@PathVariable String registrationNumber){
        return service.findConductorbyVehicle(registrationNumber);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Conductor>> allConductors(){
        return service.findAllConductors();
    }

    @GetMapping("count")
    public Integer countOfConductors(){
        return service.countOfConductors();
    }

    @DeleteMapping("delete/{idNumber}")
    public ResponseEntity<?> deleteDriver(@PathVariable String idNumber){
        return service.deleteConductorById(idNumber);
    }

}
