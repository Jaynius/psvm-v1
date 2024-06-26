package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
            if(inspection.isSpeedGovernor()) {
                updatedInspection.setSpeedGovernor(inspection.isSpeedGovernor());
            }
            if(inspection.isSeatBelts()) {
                updatedInspection.setSeatBelts(inspection.isSeatBelts());
            }
            if(inspection.isWipers()) {
                updatedInspection.setWipers(inspection.isWipers());
            }
            if(inspection.isWindShield()) {
                updatedInspection.setWindShield(inspection.isWindShield());
            }
            if(inspection.isWindows()) {
                updatedInspection.setWindows(inspection.isWindows());
            }
            if(inspection.isTires()) {
                updatedInspection.setTires(inspection.isTires());
            }
            if(inspection.isBrakes()) {
                updatedInspection.setBrakes(inspection.isBrakes());
            }
            
            repository.save(updatedInspection);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<Set<Inspection>> findInspectionByVehicleId(String registrationNumber) {
        @SuppressWarnings("null")
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle=optionalVehicle.get();
            Set<Inspection> inspection=vehicle.getInspections();
            return new ResponseEntity<>(inspection,HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   
    @Override
    public ResponseEntity<Inspection> deleteInspectionById(Long id) {
      
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

    @Override
    public ResponseEntity<Inspection> assignInspectionToVehicle(Long id, String registrationNumber) {
        Optional<Inspection> optionalInspection=repository.findById(id);
        Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
        if (optionalInspection.isPresent() && optionalVehicle.isPresent()) {
            Inspection inspection=optionalInspection.get();
            Vehicle vehicle=optionalVehicle.get();
            vehicle.getInspections().add(inspection);
            vRepository.save(vehicle);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Integer countOfInspections() {
        return (int) repository.count();
    }

}
