package com.jspiders.User_App.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController 
{
  //Exception Handler Methods
	
  @ExceptionHandler(value = IllegalArgumentException.class)
  public ResponseEntity<?> illegalArgumentException(IllegalArgumentException e)
  {
	  return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @ExceptionHandler(value = IdNotFoundException.class)
  public ResponseEntity<?> idNotFoundException(IdNotFoundException e)
  {
	  return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
  }
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e)
  {
	  return new ResponseEntity<>("This Is invalid Data,Please Try Again!!",HttpStatus.INTERNAL_SERVER_ERROR);
  }
  @ExceptionHandler(value = EmailNotFound.class)
  public ResponseEntity<?> emailNotFoundException(EmailNotFound e)
  {
	  return new ResponseEntity<>("This Is invalid Data,Please Try Again!!",HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
