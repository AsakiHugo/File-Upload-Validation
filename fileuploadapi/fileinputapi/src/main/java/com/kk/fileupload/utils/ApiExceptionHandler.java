package com.kk.fileupload.utils;

import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kk.fileupload.dto.ApiResponse;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler
	ApiResponse<List<String>> handle(ApiException e) {
		return ApiResponse.fails(e.getMessages());
	}
	
}
