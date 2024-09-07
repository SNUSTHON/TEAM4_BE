package com.example.team4_be.Dto.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DeceasedResDto {
	@Schema(description = "상태", example = "success")
	String status;
	List<UserInfoDto> users;
}
