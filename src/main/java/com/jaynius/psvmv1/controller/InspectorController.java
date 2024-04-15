package com.jaynius.psvmv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.psvmv1.model.Inspector;
import com.jaynius.psvmv1.service.InspectorService;

@RestController
@RequestMapping("/inspector")
public class InspectorController {

    @Autowired
    private final InspectorService service;

    public InspectorController(InspectorService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public void addInspector(@RequestBody Inspector newInspector){
         service.addInspector(newInspector);

    }

    @PatchMapping("/update")
    public void updateInspector(@RequestBody Inspector newInspector,@PathVariable String idNumber){
        service.updateInspectorbyId(newInspector, idNumber);
    }

    @DeleteMapping("/delete")
    public void deleteInspector(@PathVariable String idNumber){
        service.deleteInspector(idNumber);
    }



}
