package com.mindex.challenge.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.data.Compansation;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompansationServiceImplTest {
	private String createCompansationURL;
    private String readCompansationURL;
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Before
    public void setup() {
    	createCompansationURL = "http://localhost:" + port + "/compansation";
    	readCompansationURL = "http://localhost:" + port + "/compansation/{employeeId}";
    }

	@Test
    public void testCreateAndRead() {
		Compansation testCompansation = new Compansation();
		testCompansation.setEffectiveDate(LocalDate.now());
		testCompansation.setEmployee("16a596ae-edd3-4847-99fe-c4518e82c86f");
		testCompansation.setSalary((float) 199000.99);
		
		Compansation createdCompansation = restTemplate.postForEntity(createCompansationURL, testCompansation, Compansation.class).getBody();
		
		assertNotNull(createdCompansation.getEmployee());
        assertCompansationEquivalence(testCompansation, createdCompansation);
        
        Compansation readCompansation = restTemplate.getForEntity(readCompansationURL, Compansation.class, createdCompansation.getEmployee()).getBody();
        assertEquals(createdCompansation.getEmployee(), readCompansation.getEmployee());
        assertCompansationEquivalence(createdCompansation, readCompansation);
	}
	
	private static void assertCompansationEquivalence(Compansation expected, Compansation actual) {
        assertEquals(expected.getEffectiveDate(), actual.getEffectiveDate());
        assertEquals(expected.getEmployee(), actual.getEmployee());
        assertEquals(expected.getSalary(), actual.getSalary(), 0.0f);
    }
}
