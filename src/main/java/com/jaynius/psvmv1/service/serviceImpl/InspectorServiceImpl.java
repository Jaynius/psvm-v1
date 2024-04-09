package com.jaynius.psvmv1.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Inspector;
import com.jaynius.psvmv1.repository.InspectorRepository;
import com.jaynius.psvmv1.repository.VehicleRepository;
import com.jaynius.psvmv1.service.InspectorService;

@Component
public class InspectorServiceImpl implements InspectorService {

    @Autowired
    private final InspectorRepository repository;
    
    @Autowired
    private final VehicleRepository vRepository;
    
    public InspectorServiceImpl(InspectorRepository repository, VehicleRepository vRepository) {
        this.repository = repository;
        this.vRepository = vRepository;
    }

    @Override
    public void addInspector(Inspector newInspector) {
        repository.save(newInspector);
        
    }

    @Override
    public Optional<Inspector> findInspectorbyId(String idNumber) {
        Optional<Inspector> existingInspector=repository.findById(idNumber);
        if (existingInspector.isPresent()) {
            return existingInspector;
            
        }
        return null;
    }

    @Override
    public Inspector updaInspectorbyId(Inspector inspector, String idNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updaInspectorbyId'");
    }

    @Override
    public void deleteInspector(String idNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteInspector'");
    }

    @Override
    public List<Inspector> allInspector() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allInspector'");
    }

    @Override
    public List<Inspector> findInspectorsbyVehicle(String registration) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findInspectorsbyVehicle'");
    }

}
