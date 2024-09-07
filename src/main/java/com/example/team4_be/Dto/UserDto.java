package com.example.team4_be.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class UserDto {
    @Schema(description = "유저 ID", example = "1")
    private Long userId;
    @Schema(description = "유저 이름", example = "홍길동")
    private String name;
    @Schema(description = "유저 관계", example = "친구")
    private String relation;
    @Schema(description = "유저 생일", example = "1990-01-01")
    private LocalDate birth;
    @Schema(description = "유저 추모일", example = "2021-01-01")
    private LocalDate memorialDate;
    private MultipartFile profileImage;
}
