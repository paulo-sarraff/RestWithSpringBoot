package br.com.sarraff.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sarraff.converter.DozerConverter;
import br.com.sarraff.data.model.Book;
import br.com.sarraff.data.vo.BookVO;
import br.com.sarraff.exception.ResourceNotFoundException;
import br.com.sarraff.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repositorio;
	
	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repositorio.save(entity), BookVO.class);
		return vo;
	}

	public BookVO update(BookVO book) {
		var entity = repositorio.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerConverter.parseObject(repositorio.save(entity), BookVO.class);
		return vo;
	}

	public void delete(Long id) {
		Book entity = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		
		repositorio.delete(entity);
	}
	
	public BookVO findById(Long id) {
		var entity =  repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	public List<BookVO> findAll(){
		return DozerConverter.parseListObjects(repositorio.findAll(), BookVO.class) ;
	}
}