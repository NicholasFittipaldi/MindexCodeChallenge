package com.mindex.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compansation;
import com.mindex.challenge.service.CompansationService;

@RestController
public class CompansationController {
	
	@Autowired
    private CompansationService compansationService;
	
	@PostMapping("/compansation")
    public Compansation create(@RequestBody Compansation compansation) {
        return compansationService.create(compansation);
    }
	
	@GetMapping("/compansation/{employeeId}")
    public Compansation read(@PathVariable String employeeId) {
        return compansationService.read(employeeId);
    }
}
