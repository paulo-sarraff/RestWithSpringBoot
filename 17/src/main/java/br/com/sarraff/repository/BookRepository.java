package br.com.sarraff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sarraff.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
