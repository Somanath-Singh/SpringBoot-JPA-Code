package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="MOVIE")//if class name and table name same then no need to write name value in @Table annotation
@Table(name="SP_DATA_MOVIE")
public class Movie implements Serializable {
	//recomendation is make the entity class is serializable
	//serializable is used to converts the data bits and byte
	//normal object is not converted into bits and bytes  so we implements serializable interface to convert the objects to bit and bytes
	
	@Id
	@Column(name="MID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer mid;
	@Column(name="MNAME" , length=20)
	@NonNull
	private String mname;
	@NonNull
	@Column(name="YEAR" ,length=20)
	private String year;
	@NonNull
	@Column(name="RATING")
	private Float rating;

}
