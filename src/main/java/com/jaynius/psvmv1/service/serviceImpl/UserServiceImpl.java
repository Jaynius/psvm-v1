package com.jaynius.psvmv1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

   

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<Users> addUsers(Users user) {
        repository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Users> findUserById(String idnumber) {
        @SuppressWarnings("null")
        Optional<Users> user=repository.findById(idnumber);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(),HttpStatus.FOUND);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<Users> findUsersByVehicle(String registrationNumber) {
       @SuppressWarnings("null")
    Optional<Vehicle> optionaVehicle=vRepository.findById(registrationNumber);
       if (optionaVehicle.isPresent()) {
        Vehicle vehicle=optionaVehicle.get();
        Users users=vehicle.getUsers();
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
            updatedUser.setVehicle(user.getVehicle());
            updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(updatedUser);
            return new ResponseEntity<>(HttpStatus.OK);

            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("null")
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

    @Override
    public ResponseEntity<Users> assignUserToVehicle(String idNumber, String registrationNumber) {
        Optional<Users> optionalUser=repository.findById(idNumber);
        if (optionalUser.isPresent()) {
            Users user=optionalUser.get();
            
            Optional<Vehicle> optionalVehicle=vRepository.findById(registrationNumber);
            if (optionalVehicle.isPresent()) {
                Vehicle vehicle=optionalVehicle.get();
                user.setVehicle(vehicle);
                repository.save(user);
                return new ResponseEntity<>(HttpStatus.OK);
                
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Integer> countUsers() {
       int count=0;
         List<Users> userList=new ArrayList<>();
            repository.findAll().forEach(userList::add);
            if (userList.isEmpty()) {
                return null;
            }
            count=userList.size();
            return new ResponseEntity<>(count,HttpStatus.FOUND);
    }

}
