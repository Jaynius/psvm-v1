package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Inspection;
import com.jaynius.psvmv1.model.Vehicle;
import com.jaynius.psvmv1.repository.InspectionRepository;
import com.jaynius.psvmv1.repository.VehicleRepository;
import com.jaynius.psvmv1.service.InspectionService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InspectionServiceImpl implements InspectionService {
    @Autowired
    private final InspectionRepository repository;

    @Autowired
    private final VehicleRepository vRepository;

   

    

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<Inspection> addInspection(Inspection inspection) {
        repository.save(inspection);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Inspection> findInspectionById(Long id) {
   
        @SuppressWarnings("null")
        Optional<Inspection> inspection=repository.findById(id);
        if (inspection.isPresent()) {
            return new ResponseEntity<>(inspection.get(),HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Inspection> updateInspectionById(Inspection inspection, Long id) {
        @SuppressWarnings("null")
        Optional<Inspection> existingInspection=repository.findById(id);
        if (existingInspection.isPresent()) {
            Inspection updatedInspection=existingInspection.get();
            updatedInspection.setVehicle(inspection.getVehicle());
            updatedInspection.setRegistrationDate(inspection.getRegistrationDate());
            updatedInspection.setBrakes(inspection.isBrakes());
            updatedInspection.setSeatBelts(inspection.isSeatBelts());
            updatedInspection.setSpeedGovernor(inspection.isSpeedGovernor());
            updatedInspection.setTires(inspection.isTires());
            updatedInspection.setWindShield(inspection.isWindShield());
            updatedInspection.setWindows(inspection.isWindows());
            updatedInspection.setWipers(inspection.isWipers());
            updatedInspection.setInspectionDate(inspection.getInspectionDate());
            repository.save(updatedInspection);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<List<Inspection>> findInspectionByVehicleId(String registrationNumber) {
        @SuppressWarnings("null")
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle=optionalVehicle.get();
            List<Inspection> inspection=vehicle.getInspections();
            return new ResponseEntity<>(inspection,HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<Inspection> deleteInspectionById(Long id) {
       @SuppressWarnings("null")
    Optional<Inspection> inspection=repository.findById(id);
       if (inspection.isPresent()) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
        
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Inspection>> findAllInspection() {
       List<Inspection> inspectionList=new ArrayList<>();
       repository.findAll().forEach(inspectionList::add);
       if (inspectionList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
       }
       return new ResponseEntity<>(inspectionList,HttpStatus.FOUND);
    }

}
