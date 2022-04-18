package br.com.sarraff.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sarraff.converter.DozerConverter;
import br.com.sarraff.converter.custom.PersonConverter;
import br.com.sarraff.data.model.Person;
import br.com.sarraff.data.vo.PersonVO;
import br.com.sarraff.data.vo.v2.PersonVOV2;
import br.com.sarraff.exception.ResourceNotFoundException;
import br.com.sarraff.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repositorio;
	
	@Autowired
	PersonConverter converter;

	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repositorio.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.convertVOToEntity(person);
		var vo = converter.convertEntityToVO(repositorio.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		var entity = repositorio.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(repositorio.save(entity), PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		Person entity = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		
		repositorio.delete(entity);
	}
	
	public PersonVO findById(Long id) {
		var entity =  repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	@Transactional
	public PersonVO disablePerson(Long id) {
		repositorio.disablePerson(id);
		var entity =  repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public List<PersonVO> findAll(){
		return DozerConverter.parseListObjects(repositorio.findAll(), PersonVO.class) ;
	}
}