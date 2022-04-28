package br.com.sarraff.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sarraff.data.vo.PersonVO;
import br.com.sarraff.data.vo.v2.PersonVOV2;
import br.com.sarraff.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Person EndPoint", description = "Description for person", tags = {"Person EndPoint"})
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonService services;
	
	//@CrossOrigin(origins = "http://localhost:8080")
	@ApiOperation(value = "Find people recorded by ID")
	@GetMapping(value="/{id}", produces = {"application/json","application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id) {
		PersonVO personVO =  services.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}
	
	@ApiOperation(value = "Find all people")
    @GetMapping(produces =  { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<PagedModel<?>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "12") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            PagedResourcesAssembler<PersonVO> pagedResourcesAssembler) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "firstName"));

        Page<PersonVO> persons = services.findAll(pageable);
        persons
    		.stream()
    		.forEach(p -> p.add(
                   linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
                )
			);

        //PagedModel<?> resources = (PagedModel<?>) assembler.toModel(persons);

        return ResponseEntity.ok(pagedResourcesAssembler.toModel(persons));
	}
	
	//@CrossOrigin(origins = {"http://localhost:8080", "http://www.erudio.com.br"})
	@ApiOperation(value = "Create a new person" )
	@PostMapping (produces = {"application/json","application/xml","application/x-yaml"},
			consumes = {"application/json","application/xml","application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person) {
		PersonVO personVO = services.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	@PostMapping("/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return services.createV2(person);
	}

	@ApiOperation(value = "Update a person" )
	@PutMapping(produces = {"application/json","application/xml","application/x-yaml"},
			consumes = {"application/json","application/xml","application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) {
		PersonVO personVO = services.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	@ApiOperation(value = "Delete a person" )
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Disable a specific person by ID")
	@PatchMapping(value="/{id}", produces = {"application/json","application/xml", "application/x-yaml"})
	public PersonVO disablePerson(@PathVariable("id") Long id) {
		PersonVO personVO =  services.disablePerson(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}

	
}
