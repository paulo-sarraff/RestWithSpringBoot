package br.com.sarraff.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.sarraff.exception.ExceptionResponse;
import br.com.sarraff.exception.InvalidJwtAuthenticationException;
import br.com.sarraff.exception.UnsuportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
		
		@ExceptionHandler(Exception.class)
		public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
			ExceptionResponse exceptionResponse = 
					new ExceptionResponse(
							new Date(), 
							ex.getMessage(), 
							request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		@ExceptionHandler(UnsuportedMathOperationException.class)
		public final ResponseEntity<ExceptionResponse> handlerBadRequestExceptions(Exception ex, WebRequest request){
			ExceptionResponse exceptionResponse = 
					new ExceptionResponse(
							new Date(), 
							ex.getMessage(), 
							request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
			
		}
		
		@ExceptionHandler(InvalidJwtAuthenticationException.class)
		public final ResponseEntity<ExceptionResponse> handlerInvalidJwtAuthenticationException(Exception ex, WebRequest request){
			ExceptionResponse exceptionResponse = 
					new ExceptionResponse(
							new Date(), 
							ex.getMessage(), 
							request.getDescription(false));
			return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
			
		}
}