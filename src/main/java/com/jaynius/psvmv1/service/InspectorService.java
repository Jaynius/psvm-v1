package com.jaynius.psvmv1.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.Inspector;

@Service
public interface InspectorService {
    void addInspector(Inspector newInspector);
    Optional<Inspector> findInspectorbyId(String idNumber);
    ResponseEntity<Inspector> updateInspectorbyId(Inspector inspector,String idNumber);
    void deleteInspector(String idNumber);
    List<Inspector> allInspector();
    Set<Inspector> findInspectorsbyVehicle(String registration);

}
