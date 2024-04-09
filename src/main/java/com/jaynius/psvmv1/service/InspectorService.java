package com.jaynius.psvmv1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.Inspector;

@Service
public interface InspectorService {
    void addInspector(Inspector newInspector);
    Optional<Inspector> findInspectorbyId(String idNumber);
    Inspector updaInspectorbyId(Inspector inspector,String idNumber);
    void deleteInspector(String idNumber);
    List<Inspector> allInspector();
    List<Inspector> findInspectorsbyVehicle(String registration);

}
