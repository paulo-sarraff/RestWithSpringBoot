package br.com.sarraff.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.sarraff.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Paulo");
		person.setLastName("Sarraff");
		person.setAddress("Manaus/AM - Brasil");
		person.setGender("Male");
		
		return person;
	}

}
