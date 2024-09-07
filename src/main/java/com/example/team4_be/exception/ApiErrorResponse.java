package com.example.team4_be.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
	private String status;
	private String message;
	public ApiErrorResponse(String message) {
		this.status = "error";
		this.message = message;
	}
}
