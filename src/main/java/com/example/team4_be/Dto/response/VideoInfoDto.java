package com.example.team4_be.Dto.response;

import com.example.team4_be.entity.VideoType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VideoInfoDto {
	@Schema(description = "비디오 ID", example = "1")
	Long id;
	@Schema(description = "비디오 제목", example = "비디오 제목")
	String videoUrl;
	@Schema(description = "비디오 타입", example = "SINGING")
	VideoType videoType;
}
