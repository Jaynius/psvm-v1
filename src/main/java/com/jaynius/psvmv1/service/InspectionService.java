package com.jaynius.psvmv1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.Inspection;

@Service
public interface InspectionService {
    ResponseEntity<Inspection> addInspection(Inspection inspection);
    ResponseEntity<Inspection> findInspectionById(Long id);
    ResponseEntity<Inspection> updateInspectionById(Inspection inspection,Long id);
    ResponseEntity<List<Inspection>> findInspectionByVehicleId(String registrationNumber);
    ResponseEntity<Inspection> deleteInspectionById(Long id);
    ResponseEntity<List<Inspection>> findAllInspection();


}
