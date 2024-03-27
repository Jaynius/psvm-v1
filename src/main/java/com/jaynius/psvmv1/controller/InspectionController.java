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

import com.jaynius.psvmv1.model.Inspection;
import com.jaynius.psvmv1.service.InspectionService;

@RestController
public class InspectionController {

    private final InspectionService service;
    public InspectionController(InspectionService service) {
        this.service = service;
    }

    @PostMapping("/inspections/add")
    ResponseEntity<Inspection> addInspection(@RequestBody Inspection inspection){
        return service.addInspection(inspection);

    }
    @GetMapping("/inspections/inspection/{id}")
    ResponseEntity<Inspection> findInspectionById(@PathVariable Long id){
        return service.findInspectionById(id);

    }
    @PutMapping("/inspections/update/{id}")
    ResponseEntity<Inspection> updateInspectionById(@RequestBody Inspection inspection,@PathVariable Long id){
        return service.updateInspectionById(inspection, id);

    }
    @GetMapping("/inspections/vehicle/{registrationnumber}")
    ResponseEntity<List<Inspection>> findInspectionByVehicleId(@PathVariable String registrationNumber){
        return service.findInspectionByVehicleId(registrationNumber);

    }
    @DeleteMapping("/inspections/delete/{id}")
    ResponseEntity<Inspection> deleteInspectionById(@PathVariable Long id){
        return service.deleteInspectionById(id);

    }
    @GetMapping("/inspections")
    ResponseEntity<List<Inspection>> findAllInspection(){
        return service.findAllInspection();
    }

    
} 