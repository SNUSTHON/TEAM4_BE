package com.example.team4_be.Dto.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VideoResponseDto {
	@Schema(description = "상태", example = "success")
	String status;
	List<VideoInfoDto> videos;
	@Schema(description = "비디오 총 개수", example = "1")
	int totalVideos;

}
