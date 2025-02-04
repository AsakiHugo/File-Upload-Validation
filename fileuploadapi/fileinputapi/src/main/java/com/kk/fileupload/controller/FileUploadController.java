package com.kk.fileupload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kk.fileupload.dto.ApiResponse;
import com.kk.fileupload.service.FileUploadService;

@RestController
@CrossOrigin("*")
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping("/upload")
	public ApiResponse<String> uploadFile(@RequestBody MultipartFile file) {
		return fileUploadService.upload(file);
	}
	
	@GetMapping("/retrive")
	public ApiResponse<List<MenuDetails>> retriveFile() {
		return fileUploadService.retrive();
	}
	
}
