package com.mindex.challenge.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompansationRepository;
import com.mindex.challenge.data.Compansation;
import com.mindex.challenge.service.CompansationService;

@Service
public class CompansationServiceImpl implements CompansationService {
	
	@Autowired
    private CompansationRepository compansationRepository;

	@Override
	public Compansation create(Compansation compansation) {
		if (compansation.getEffectiveDate() == null)
			compansation.setEffectiveDate(LocalDate.now());
		
		compansationRepository.insert(compansation);
		
		return compansation;
	}

	@Override
	public Compansation read(String employeeId) {
		Compansation compansation = compansationRepository.findByEmployee(employeeId);
		
		if (compansation == null) {
            throw new RuntimeException("Invalid employeeId: " + employeeId + ". No Compansations Found.");
        }
		
		return compansation;
	}
}
