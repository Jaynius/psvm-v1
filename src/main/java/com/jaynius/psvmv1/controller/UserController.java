package com.jaynius.psvmv1.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.model.Users;
import com.jaynius.psvmv1.service.UsersService;

@RestController
public class UserController {
    private final UsersService service;

    public UserController(UsersService service) {
        this.service = service;
    }
    @PostMapping("/users/add")
    public ResponseEntity<Users> addUsers(@RequestBody Users user){
        return service.addUsers(user);
    }
    @GetMapping("/users/user/{idnumber}")
    public ResponseEntity<Users> findUserById( @PathVariable String idnumber){
        return service.findUserById(idnumber);
    }
    @GetMapping("/users/vehicle/{registrationNumber}")
    public ResponseEntity<Set<Users>> findUsersByVehicle(@PathVariable String registrationNumber){
        return service.findUsersByVehicle(registrationNumber);
    }
    @PutMapping("/users/update/{idNumber}")
    public ResponseEntity<Users> updateUserById(@RequestBody Users user,@PathVariable String idNumber){
        return service.updateUserById(user, idNumber);
    }
    @DeleteMapping("users/delete/{idNumber}")
    public ResponseEntity<Users> deleteUserById(@PathVariable String idnumber){
        return service.deleteUserById(idnumber);
    }
    @GetMapping("/users")
    public ResponseEntity<List<Users>> findAllUsers(){
        return service.findAllUsers();
    }

}
