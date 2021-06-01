package com.ya.performance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Cette classe permet de générer une erreur HTTP 404 (Not FOUND) 
 * en stipulant le message lié à notre exception ResourceNotFound 
 * Si la resource n'est pas trouvée, une erreur 404 s'affiche et on obtient le message "Prospect/Simulation + id not found" 
 * @author ahkeceli
 * @see ResourceNotFoundException
 */

@ControllerAdvice
public class ResourceNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String ResourceNotFoundHandler(ResourceNotFoundException e) {
		return e.getMessage();
	}
}
