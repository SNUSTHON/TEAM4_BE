package com.example.team4_be.Controller;

import com.example.team4_be.Dto.UserDto;
import com.example.team4_be.Dto.response.ApiSuccessResponse;
import com.example.team4_be.Service.UserService;
import com.example.team4_be.config.ServerProperties;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ApiSuccessResponse addUser (
            @ModelAttribute UserDto userDto) throws Exception {
            return userService.addUser(userDto);
    }
}
