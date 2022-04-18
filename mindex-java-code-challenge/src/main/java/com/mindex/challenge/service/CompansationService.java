package com.mindex.challenge.service;

import com.mindex.challenge.data.Compansation;

public interface CompansationService {
	Compansation create(Compansation compansation);
	Compansation read(String employeeId);
}
