package br.com.sarraff.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sarraff.data.model.Person;
import br.com.sarraff.exception.ResourceNotFoundException;
import br.com.sarraff.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repositorio;

	public Person create(Person person) {
		return repositorio.save(person);
	}
	
	public Person update(Person person) {
		Person entity = repositorio.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repositorio.save(entity);
	}

	public void delete(Long id) {
		Person entity = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		
		repositorio.delete(entity);
	}
	
	public Person findById(Long id) {
		return repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
	}
	
	public List<Person> findAll(){
		return repositorio.findAll();
	}
}