package com.jsp.Crud_SpringBoot.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(generator = "x")
	@SequenceGenerator(initialValue = 1001, allocationSize = 1, name = "x")
	private int id;
	private String name;
	private long mobile;
	private String gender;
	private int math;
	private int science;
	private int english;
	
	public double getPercentage()
	{
		return (math + english + science) /3.0;
	}
}
