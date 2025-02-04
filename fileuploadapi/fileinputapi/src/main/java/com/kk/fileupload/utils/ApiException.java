package com.kk.fileupload.utils;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<String> messages;

	public ApiException(List<String> messages) {
		super();
		this.messages = messages;
	}
	
	public ApiException(String message) {
		super();
		this.messages = List.of(message);
	}
	
	public List<String> getMessages() {
		return messages;
	}

}
