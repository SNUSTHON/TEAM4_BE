package com.example.team4_be.Dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiSuccessResponse {
	private String status;
	private String message;
	public ApiSuccessResponse(String message) {
		this.status = "success";
		this.message = message;
	}
}
