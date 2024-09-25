package com.nt.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tourist implements Serializable {

	@Id
	private String id;
	private String touristname;
	private String nativeplace;
	private Float age;
	private String paspotNo;
	private Long contactNo;
	private Boolean isVaccinated;
}
