package com.jaynius.psvmv1.DTO;

import java.util.HashSet;
import java.util.Set;

import com.jaynius.psvmv1.model.Inspection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class InspectorDTO {

    private String idNumber;
    private String name,email,contact,password;
    private Set<Inspection> inspections=new HashSet<>();

}
