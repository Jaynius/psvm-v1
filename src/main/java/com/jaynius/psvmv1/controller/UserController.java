package com.jaynius.psvmv1.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.model.Users;
import com.jaynius.psvmv1.service.UsersService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UsersService service;

    public UserController(UsersService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public ResponseEntity<Users> addUsers(@RequestBody Users user){
        return service.addUsers(user);
    }
    @GetMapping("/user/{idnumber}")
    public ResponseEntity<Users> findUserById( @PathVariable String idnumber){
        return service.findUserById(idnumber);
    }
    @GetMapping("/vehicle/{registrationNumber}")
    public ResponseEntity<Set<Users>> findUsersByVehicle(@PathVariable String registrationNumber){
        return service.findUsersByVehicle(registrationNumber);
    }
    @PatchMapping("/update/{idNumber}")
    public ResponseEntity<Users> updateUserById(@RequestBody Users user,@PathVariable String idNumber){
        return service.updateUserById(user, idNumber);
    }
    @DeleteMapping("/delete/{idNumber}")
    public ResponseEntity<Users> deleteUserById(@PathVariable String idnumber){
        return service.deleteUserById(idnumber);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Users>> findAllUsers(){
        return service.findAllUsers();
    }
    @PatchMapping("/assign/{idNumber}/vehicle/{registrationNumber}")
    public ResponseEntity<Users> assignUserToVehicle(@PathVariable String idNumber, @PathVariable String registrationNumber){
        return service.assignUserToVehicle(idNumber, registrationNumber);
    }

    @GetMapping("/count")
    public Integer countUsers(){
        return service.countUsers();
    }

    @PatchMapping("/location/{idNumber}")
    public ResponseEntity<Users> setUserLocation(@PathVariable String idNumber,@RequestBody Users user){
        return service.assignLocation(idNumber, user);
    }

    @GetMapping("/login")
    ResponseEntity<?> userLogin(@PathVariable String idNumber,@PathVariable String password){
        return service.userLogin(idNumber, password);
    }
}
