package com.example.team4_be.Dto.response;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserInfoDto {
	@Schema(description = "유저 ID", example = "1")
	Long id;
	@Schema(description = "유저 이름", example = "홍길동")
	String name;
	@Schema(description = "유저 관계", example = "친구")
	String relation;
	@Schema(description = "유저 생일", example = "1990-01-01")
	LocalDate birth;
	@Schema(description = "유저 추모일", example = "2021-01-01")
	LocalDate memorialDate;
}
