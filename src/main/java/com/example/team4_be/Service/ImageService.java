package com.example.team4_be.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.team4_be.config.ServerProperties;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
	private final ServerProperties serverProperties;
	public void uploadImages(List<MultipartFile> photos) throws Exception{
		File uploadDirectory = new File(serverProperties.getResource_path());
		if (!uploadDirectory.exists()) {
			uploadDirectory.mkdirs();  // 디렉토리 생성
		}
		for (MultipartFile photo : photos) {
			String originalFilename = photo.getOriginalFilename();  // 파일 이름 가져오기
			if (originalFilename != null && !originalFilename.isEmpty()) {
				Path filePath = Paths.get(serverProperties.getResource_path() + originalFilename);
				Files.write(filePath, photo.getBytes());  // 파일 저장
				System.out.println("File saved at: " + filePath);
			}
		}
	}

	/**
	 * 이미지 파일을 업로드한다.
	 * @param photo 이미지 파일 (MultipartFile)
	 * @return 파일 저장 url
	 *
	 */
	public String uploadImage(MultipartFile photo) throws Exception{
		File uploadDirectory = new File(serverProperties.getResource_path());
		if (!uploadDirectory.exists()) {
			uploadDirectory.mkdirs();  // 디렉토리 생성
		}
		String originalFilename = photo.getOriginalFilename();  // 파일 이름 가져오기
		if (originalFilename != null && !originalFilename.isEmpty()) {
			Path filePath = Paths.get(serverProperties.getResource_path() + originalFilename);
			Files.write(filePath, photo.getBytes());  // 파일 저장
			System.out.println("File saved at: " + filePath);
		}
		return serverProperties.getUrl() + originalFilename;
	}

}
