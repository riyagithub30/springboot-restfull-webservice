package com.springboot.rest.webservice.restfulwebservice.ExceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionalHandler extends ResponseEntityExceptionHandler 
{
	
	/*@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception{
		
		ErrorDetails errors = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errors , HttpStatus.INTERNAL_SERVER_ERROR);	
	}*/
	
	@ExceptionHandler(UserNotFoundException.class)
	//@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
		ErrorDetails errors = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errors , HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	//@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleAllPossibleException(Exception ex , WebRequest request){
		ErrorDetails errors = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
		//ErrorDetails errors = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"NAA");
		
		return new ResponseEntity<ErrorDetails>(errors , HttpStatus.NOT_FOUND);
	}
	
	//handling exception handling for validation
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		
		ErrorDetails errors = new ErrorDetails(LocalDateTime.now(),ex.getFieldError().getDefaultMessage(),request.getDescription(false));
		
		return new ResponseEntity(errors , HttpStatus.BAD_REQUEST);
	
	}
	
}
