package br.com.sarraff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sarraff.data.vo.PersonVO;
import br.com.sarraff.data.vo.v2.PersonVOV2;
import br.com.sarraff.services.PersonService;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonService services;
	
	@GetMapping(value="/{id}", produces = {"application/json","application/xml"})
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
	
	@GetMapping(produces = {"application/json","application/xml"})
	public List<PersonVO> findAll() {
		return services.findAll();
	}
	
	@PostMapping (produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"})
	public PersonVO create(@RequestBody PersonVO person) {
		return services.create(person);
	}

	@PostMapping("/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return services.createV2(person);
	}
	
	@PutMapping(produces = {"application/json","application/xml"},
			consumes = {"application/json","application/xml"})
	public PersonVO update(@RequestBody PersonVO person) {
		return services.update(person);
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
