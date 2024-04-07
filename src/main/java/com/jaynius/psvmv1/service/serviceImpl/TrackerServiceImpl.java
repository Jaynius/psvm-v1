package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Tracker;
import com.jaynius.psvmv1.model.Vehicle;
import com.jaynius.psvmv1.repository.TrackerRepository;
import com.jaynius.psvmv1.repository.VehicleRepository;
import com.jaynius.psvmv1.service.TrackerService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TrackerServiceImpl implements TrackerService{

    @Autowired
    private final TrackerRepository repository;

    @Autowired
    private final VehicleRepository vRepository;

   

   

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<Tracker> addTracker(Tracker tracker) {
        repository.save(tracker);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Tracker> findTrackerById(String serialNumber) {
       @SuppressWarnings("null")
    Optional<Tracker> tracker=repository.findById(serialNumber);
       if (tracker.isPresent()) {
        return new ResponseEntity<>(tracker.get(),HttpStatus.FOUND);
        
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Tracker> updateTrackerById(Tracker tracker, String serialNumber) {
       @SuppressWarnings("null")
    Optional<Tracker> existingTracker=repository.findById(serialNumber);
       if (existingTracker.isPresent()) {
        Tracker updatedTracker=existingTracker.get();
        updatedTracker.setSerialNumber(tracker.getSerialNumber());
        updatedTracker.setVehicle(tracker.getVehicle());
        updatedTracker.setSpeed(tracker.getSpeed());
        updatedTracker.setGpsCordinates(tracker.getGpsCordinates());
        updatedTracker.setUpdatedAt(tracker.getUpdatedAt());
        repository.save(updatedTracker);
        return new ResponseEntity<>(HttpStatus.OK);
        
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<Tracker> deleteTrackerById(String serialNumber) {
        Optional<Tracker> tracker=repository.findById(serialNumber);
        if (tracker.isPresent()) {
            repository.deleteById(serialNumber);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Tracker>> findAllTrackers() {
       List<Tracker> trackelList=new ArrayList<>();
       repository.findAll().forEach(trackelList::add);
       if (trackelList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        
       }
       return new ResponseEntity<>(trackelList,HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<Tracker> findTrackerByVehicle(String registrationnumber) {
        @SuppressWarnings("null")
        Optional<Vehicle> optionaVehicle=vRepository.findById(registrationnumber);
        if (optionaVehicle.isPresent()) {
            Vehicle vehicle=optionaVehicle.get();
            Tracker tracker=vehicle.getTracker();
            return new ResponseEntity<>(tracker,HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
