package com.example.team4_be.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team4_be.Dto.response.ApiSuccessResponse;
import com.example.team4_be.Dto.response.VideoResponseDto;
import com.example.team4_be.Service.VideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/video")
@RequiredArgsConstructor
public class VideoController {
	private final VideoService videoService;
	@GetMapping
	public VideoResponseDto getVideo() {
		return videoService.getVideos();
	}

	@PostMapping
	public ApiSuccessResponse addVideo() {
		return videoService.addVideo();
	}

}
