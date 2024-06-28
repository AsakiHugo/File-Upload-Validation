package com.kk.fileupload.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

	@Id
	private String id;
	private String name;
	private String products;
	private String description;

}
