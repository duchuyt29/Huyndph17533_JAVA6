package java6bai2.java6_bai2.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	String name;

	Boolean gender = false;

	Double marks = 0.0;

	Contact contact;

	List<String> subjects;
}
