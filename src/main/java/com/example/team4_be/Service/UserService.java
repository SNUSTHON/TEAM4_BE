package com.example.team4_be.Service;

import com.example.team4_be.Dto.UserDto;
import com.example.team4_be.Dto.response.ApiSuccessResponse;
import com.example.team4_be.Dto.response.DeceasedResDto;
import com.example.team4_be.Repository.UserImageRepository;
import com.example.team4_be.Repository.UserRepository;
import com.example.team4_be.entity.User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserImageRepository userImageRepository;
    private final ImageService imageService;


    public ApiSuccessResponse addUser(UserDto userDto) throws Exception {
        // Convert MultipartFile to a String (e.g., file URL or file path)
        String profileImagePath = imageService.uploadImage(userDto.getProfileImage());

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
        ApiSuccessResponse apiSuccessResponse = new ApiSuccessResponse("Missing person added successfully");
        return apiSuccessResponse;
    }

    public DeceasedResDto getUser() { //Todo : Change the return type to List<DeceasedResDto>
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new DeceasedResDto(user);
    }

}
