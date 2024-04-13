package com.jaynius.psvmv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaynius.psvmv1.model.Drivers;

@Repository
public interface DriverRepository extends JpaRepository<Drivers, String> {

}
