package com.kk.fileupload.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse<T> {
	
	private boolean success;
	private LocalDateTime responseAt;
	private T payload;
	
	private ApiResponse(boolean success, LocalDateTime responseAt, T payload) {
		super();
		this.success = success;
		this.responseAt = responseAt;
		this.payload = payload;
	}
	
	public static<T> ApiResponse<T> success(T payload) {
		return new ApiResponse<T>(true, LocalDateTime.now(), payload);
	}

	public static<T> ApiResponse<T> fails(T payload) {
		return new ApiResponse<T>(false, LocalDateTime.now(), payload);
	}
	
}
