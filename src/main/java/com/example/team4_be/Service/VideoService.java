package com.example.team4_be.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.team4_be.Dto.response.ApiSuccessResponse;
import com.example.team4_be.Dto.response.VideoInfoDto;
import com.example.team4_be.Dto.response.VideoResponseDto;
import com.example.team4_be.config.ServerProperties;
import com.example.team4_be.entity.VideoType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoService {
	private final ServerProperties serverProperties;
	public VideoResponseDto getVideos() {
		VideoInfoDto videoInfoDto = VideoInfoDto.builder()
				.id(1L)
				.videoType(VideoType.BIRTHDAY)
				.videoUrl(serverProperties.getVideo_url() + "/birthday.mp4")
				.build();

		return VideoResponseDto.builder()
				.videos(List.of(videoInfoDto))
				.status("success")
				.totalVideos(1)
				.build();
	}

	public ApiSuccessResponse addVideo() {
		return new ApiSuccessResponse("Video creation started");
	}
}
