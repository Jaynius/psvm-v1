package com.jaynius.psvmv1.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jaynius.psvmv1.model.Users;

@Service
public interface UsersService {
    ResponseEntity<Users> addUsers(Users user);
    ResponseEntity<Users> findUserById(String idnumber);
    ResponseEntity<Set<Users>> findUsersByVehicle(String registrationNumber);
    ResponseEntity<Users> updateUserById(Users user,String idNumber);
    ResponseEntity<Users> deleteUserById(String idnumber);
    ResponseEntity<List<Users>> findAllUsers();


}
