package com.jaynius.psvmv1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.Tracker;

@Service
public interface TrackerService {
    ResponseEntity<Tracker> addTracker(Tracker tracker);
    ResponseEntity<Tracker> findTrackerById(String serialNumber);
    ResponseEntity<Tracker> updateTrackerById( Tracker tracker,String serialNumber);
    ResponseEntity<Tracker> deleteTrackerById(String serialNumber);
    ResponseEntity<List<Tracker>> findAllTrackers();

}
