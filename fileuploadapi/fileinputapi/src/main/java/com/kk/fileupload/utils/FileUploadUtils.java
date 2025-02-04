package com.kk.fileupload.utils;

import java.util.Random;

import com.kk.fileupload.controller.MenuDetails;
import com.kk.fileupload.entity.Menu;

public class FileUploadUtils {

	private static final String DOMAIN = "HUGO";

	public static String generateKey() {
		Random random = new Random();
		String nums = "" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10)
				+ random.nextInt(10);
		return DOMAIN + "-" + nums;
	}

	public static String uploaded(String domain) {
		return "%s has been successfully uploaded!".formatted(domain);
	}

	public static MenuDetails toDto(Menu entity) {
		return new MenuDetails(entity.getId(), entity.getName(), entity.getProducts(), entity.getDescription());
	}
	
}
