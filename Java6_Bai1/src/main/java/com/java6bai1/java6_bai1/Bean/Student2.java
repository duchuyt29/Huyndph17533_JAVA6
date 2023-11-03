package com.java6bai1.java6_bai1.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student2 {
	String name;

	Boolean gender = false;

	Double marks = 0.0;

	Contact contact;

	List<String> subjects;
}
