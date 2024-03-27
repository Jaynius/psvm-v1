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

import com.jaynius.psvmv1.model.Tracker;
import com.jaynius.psvmv1.service.TrackerService;

@RestController
public class TrackerController {
    private final TrackerService service;

    public TrackerController(TrackerService service) {
        this.service = service;
    }

    @PostMapping("/drivers/add")
    public  ResponseEntity<Tracker> addTracker(@RequestBody Tracker tracker){
        return service.addTracker(tracker);

    }
    @GetMapping("/trackers/tracker/{serialNumber}")
    public ResponseEntity<Tracker> findTrackerById(@PathVariable String serialNumber){
        return service.findTrackerById(serialNumber);

    }
    @PutMapping("/trackers/update/{serialNumber}")
    public ResponseEntity<Tracker> updateTrackerById( @RequestBody Tracker tracker,@PathVariable String serialNumber){
        return service.updateTrackerById(tracker, serialNumber);

    }
    @DeleteMapping("/trackers/delete/{serialnumber}")
    public ResponseEntity<Tracker> deleteTrackerById(@PathVariable String serialNumber){
        return service.deleteTrackerById(serialNumber);

    }
    @GetMapping("/trackers")
    public ResponseEntity<List<Tracker>> findAllTrackers(){
        return service.findAllTrackers();

    }
    @GetMapping("/tracker/vehicle/{registrationNumber}")
    ResponseEntity<List<Tracker>> findTrackerByVehicle( @PathVariable String registrationnumber){
        return service.findTrackerByVehicle(registrationnumber);
    }

}
