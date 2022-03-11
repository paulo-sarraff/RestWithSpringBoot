package br.com.sarraff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sarraff.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
