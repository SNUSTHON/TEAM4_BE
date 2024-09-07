package com.example.team4_be.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class UserDto {
    private Long userId;
    private String name;
    private String relation;
    private LocalDate birth;
    private LocalDate memorialDate;
    private MultipartFile profileImage;
}
