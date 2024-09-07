package com.example.team4_be.Service;

import com.example.team4_be.Dto.UserDto;
import com.example.team4_be.Repository.UserRepository;
import com.example.team4_be.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserDto userDto) throws IOException {
        // Convert MultipartFile to a String (e.g., file URL or file path)
        String profileImagePath = saveProfileImage(userDto.getProfileImage());

        // Create a new User entity
        User user = new User(
                userDto.getName(),
                userDto.getRelation(),
                userDto.getBirth(),
                userDto.getMemorialDate(),
                profileImagePath
        );

        // Save the deceased person in the database
        userRepository.save(user);
    }

    private String saveProfileImage(MultipartFile profileImage) throws IOException {
        // 실제로 이미지 파일을 서버에 저장하는 로직
        String folder = "team4_be/src/main/resources/static/uploaded_images/";
        Path path = Paths.get(folder + profileImage.getOriginalFilename());
        Files.write(path, profileImage.getBytes());
        return path.toString();  // 이미지 파일의 경로를 반환
    }
}
