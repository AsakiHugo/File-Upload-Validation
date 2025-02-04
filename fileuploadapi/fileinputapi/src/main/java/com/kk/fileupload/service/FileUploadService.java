package com.kk.fileupload.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.kk.fileupload.controller.MenuDetails;
import com.kk.fileupload.dao.MenuDao;
import com.kk.fileupload.dto.ApiResponse;
import com.kk.fileupload.entity.Menu;
import com.kk.fileupload.utils.ApiException;
import com.kk.fileupload.utils.FileUploadUtils;

@Component
public class FileUploadService {

	private static final String DOMAIN = "File";
	
	@Autowired
	private MenuDao repo;

	public ApiResponse<String> upload(MultipartFile file) {

		var list = read(file, ",");

		validate(list);

		var entities = list.stream().map(arr -> new Menu(FileUploadUtils.generateKey(), arr[0], arr[1], arr[2]))
				.toList();
		
		repo.saveAll(entities);

		return ApiResponse.success(FileUploadUtils.uploaded(DOMAIN));
	}

	public ApiResponse<List<MenuDetails>> retrive() {
		var resultList = repo.findAll().stream().map(FileUploadUtils::toDto).toList();
		return ApiResponse.success(resultList);
	}
	
	private List<String[]> read(MultipartFile file, String delimiter) {

		try {

			var reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
			var list = new ArrayList<String[]>();
			String line = null;

			while (null != (line = reader.readLine())) {
				list.add(line.split(delimiter));
			}

			return list;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	private void validate(List<String[]> list) {

		if (null == list || list.isEmpty()) {
			throw new ApiException("Your file has no data!");
		}

		var messages = new ArrayList<String>();

		for (var i = 0; i < list.size(); i++) {

			var array = list.get(i);

			if (array.length != 3) {
				messages.add("Invalid data format at line %d".formatted(i + 1));
			}

			if (array.length >= 1 && array[0].isBlank()) {
				messages.add("There is no category name at line %d".formatted(i + 1));
			}

			if (array.length >= 2 && array[1].isBlank()) {
				messages.add("There is no products at line %d".formatted(i + 1));
			}

			if (array.length >= 3 && array[2].isBlank()) {
				messages.add("There is no description at line %d".formatted(i + 1));
			}

		}

		if (!messages.isEmpty()) {
			throw new ApiException(messages);
		}

	}

}
