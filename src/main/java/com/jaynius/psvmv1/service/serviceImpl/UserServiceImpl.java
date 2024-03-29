package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jaynius.psvmv1.model.Users;
import com.jaynius.psvmv1.model.Vehicle;
import com.jaynius.psvmv1.repository.UserRepository;
import com.jaynius.psvmv1.repository.VehicleRepository;
import com.jaynius.psvmv1.service.UsersService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserServiceImpl implements UsersService {

    @Autowired
    private final UserRepository repository;

    @Autowired
    private final VehicleRepository vRepository;

   

    @Override
    public ResponseEntity<Users> addUsers(Users user) {
        repository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Users> findUserById(String idnumber) {
        Optional<Users> user=repository.findById(idnumber);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(),HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<Set<Users>> findUsersByVehicle(String registrationNumber) {
       Optional<Vehicle> optionaVehicle=vRepository.findById(registrationNumber);
       if (optionaVehicle.isPresent()) {
        Vehicle vehicle=optionaVehicle.get();
        Set<Users> users=vehicle.getUsers();
        return new ResponseEntity<>(users,HttpStatus.FOUND);
        
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Users> updateUserById(Users user, String idNumber) {
        Optional<Users> existingUser=repository.findById(idNumber);
        if (existingUser.isPresent()) {
            Users updatedUser=existingUser.get();
            updatedUser.setIdNumber(user.getIdNumber());
            updatedUser.setName(user.getName());
            updatedUser.setContacts(user.getContacts());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setVehicles(user.getVehicles());
            repository.save(updatedUser);
            return new ResponseEntity<>(HttpStatus.OK);

            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Users> deleteUserById(String idnumber) {
        Optional<Users> user=repository.findById(idnumber);
        if (user.isPresent()) {
            repository.deleteById(idnumber);
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Users>> findAllUsers() {
       List<Users> userlList=new ArrayList<>();
       repository.findAll().forEach(userlList::add);
       if (userlList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    
       }
       return new ResponseEntity<>(userlList,HttpStatus.FOUND);
    }

}
