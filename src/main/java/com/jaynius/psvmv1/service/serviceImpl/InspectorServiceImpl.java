package com.jaynius.psvmv1.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Inspector;
import com.jaynius.psvmv1.model.Vehicle;
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
        Inspector inspector = new Inspector();
        inspector.setIdNumber(newInspector.getIdNumber());
        inspector.setName(newInspector.getName());
        inspector.setContacts(newInspector.getContacts());
        inspector.setEmail(newInspector.getEmail());
        inspector.setPassword(newInspector.getPassword());
        repository.save(inspector);
        
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
    public ResponseEntity<Inspector> updateInspectorbyId(Inspector inspector, String idNumber) {
        Optional<Inspector> existingInspector=repository.findById(idNumber);
        if (existingInspector.isPresent()) {
            Inspector updatedInspector=existingInspector.get();
            if(inspector.getName()!=null) {
                updatedInspector.setName(inspector.getName());
            }
            if(inspector.getContacts()!=null) {
                updatedInspector.setContacts(inspector.getContacts());
            }
            if(inspector.getEmail()!=null) {
                updatedInspector.setEmail(inspector.getEmail());
            }
            if(inspector.getPassword()!=null) {
                updatedInspector.setPassword(inspector.getPassword());
            }
            repository.save(updatedInspector);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteInspector(String idNumber) {
        repository.deleteById(idNumber);
    }

    @Override
    public List<Inspector> allInspector() {
        return repository.findAll();
    }

    @Override
    public Set<Inspector> findInspectorsbyVehicle(String registration) {
        Optional<Vehicle> optionalVehicle =vRepository.findById(registration);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle=optionalVehicle.get();
            Set<Inspector> inspectors=vehicle.getInspectors();
            return inspectors;
            
        }

        return null;
    }
    

}
