package com.jaynius.psvmv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaynius.psvmv1.model.VehicleOwners;

@Repository
public interface VehicleOwnerRepository extends JpaRepository<VehicleOwners,String>{

}
