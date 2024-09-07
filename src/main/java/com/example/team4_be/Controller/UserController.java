package com.example.team4_be.Controller;

import com.example.team4_be.Dto.UserDto;
import com.example.team4_be.Service.UserService;
import com.example.team4_be.config.ServerProperties;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@Tag(name = "User", description = "유저 API")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ServerProperties serverProperties;

    @PostMapping(value = "/deceased", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> addUser(
            @ModelAttribute UserDto userDto) {
        System.out.println(serverProperties.getUrl());
        try {
            userService.addUser(userDto);  // 수정된 부분: 인스턴스 변수로 호출
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Missing person added successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Internal Server Error");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
