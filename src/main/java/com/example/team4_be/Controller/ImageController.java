package com.example.team4_be.Controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.team4_be.Service.ImageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")
public class ImageController {
	private final ImageService imageService;

	@Operation(summary = "Upload multiple images", description = "Upload one or more image files")
	@PostMapping
	public void uploadImages(
		@Parameter(description = "List of image files to upload", content = @Content(mediaType = "multipart/form-data"))
		@RequestPart("photos") List<MultipartFile> photos) throws Exception {

		// For debugging purpose
		System.out.println("Uploading images");
		System.out.println(photos);
		System.out.println(photos.size() + " images received");
		System.out.println(photos.get(0).getOriginalFilename());

		imageService.uploadImages(photos);
	}

	@Operation(summary = "Upload a single image", description = "Upload a single image file")
	@PostMapping(value = "/single", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadImage(
		@Parameter(description = "Image file to upload", content = @Content(mediaType = "multipart/form-data"))
		@RequestPart("photos") MultipartFile photo) throws Exception {

		// For debugging purpose
		System.out.println("Uploading a single image");
		System.out.println(photo);
		System.out.println("Image received: " + photo.getOriginalFilename());

		// Assuming imageService is properly autowired and initialized
		return imageService.uploadImage(photo);
	}
}
