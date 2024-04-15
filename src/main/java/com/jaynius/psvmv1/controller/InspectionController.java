package com.jaynius.psvmv1.controller;

import java.util.List;

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

import com.jaynius.psvmv1.model.Inspection;
import com.jaynius.psvmv1.service.InspectionService;

@RestController
@RequestMapping("/inspection")
@CrossOrigin
public class InspectionController {

    private final InspectionService service;
    public InspectionController(InspectionService service) {
        this.service = service;
    }

    @PostMapping("/add")
    ResponseEntity<Inspection> addInspection(@RequestBody Inspection inspection){
        return service.addInspection(inspection);

    }
    @GetMapping("/{id}")
    ResponseEntity<Inspection> findInspectionById(@PathVariable Long id){
        return service.findInspectionById(id);

    }
    @PatchMapping("/update/{id}")
    ResponseEntity<Inspection> updateInspectionById(@RequestBody Inspection inspection,@PathVariable Long id){
        return service.updateInspectionById(inspection, id);

    }
    @GetMapping("/vehicle/{registrationnumber}")
    ResponseEntity<List<Inspection>> findInspectionByVehicleId(@PathVariable String registrationNumber){
        return service.findInspectionByVehicleId(registrationNumber);

    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Inspection> deleteInspectionById(@PathVariable Long id){
        return service.deleteInspectionById(id);

    }
    @GetMapping("/all")
    ResponseEntity<List<Inspection>> findAllInspection(){
        return service.findAllInspection();
    }

    @PatchMapping("/assign/{id}/vehicle/{registrationNumber}")
    ResponseEntity<Inspection> assignInspectionToVehicle(@PathVariable Long id, @PathVariable String registrationNumber){
        return service.assignInspectionToVehicle(id, registrationNumber);
    }

    @GetMapping("/count")
    public Integer countOfInspections(){
        return service.countOfInspections();
    }

    
} 