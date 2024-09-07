package com.example.team4_be.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(HttpServletRequest request, Exception error) {
		log.error("Exception message({}), path({} {})", error.getMessage(), request.getMethod(),
			request.getRequestURI());
		return ResponseEntity.ok(new ApiErrorResponse(error.getMessage()));
	}
}
