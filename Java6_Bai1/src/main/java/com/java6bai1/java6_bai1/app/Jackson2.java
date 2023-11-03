package com.java6bai1.java6_bai1.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.java6bai1.java6_bai1.Bean.Contact;
import com.java6bai1.java6_bai1.Bean.Student2;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jackson2 {
	public static void main(String[] args) throws Exception {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5();
//		demo6();
		demo7();
	}

private static void demo7() throws Exception {
		Contact contact = new Contact("huynd@gmail.com", "0989898989", null);
		List<String> subjects = Arrays.asList("WEB205","COM108");
		Student2 student = new Student2("Huy Nguyễn Đức", true, 9.8, contact, subjects);
		
		ObjectMapper mapper = new ObjectMapper();
		 // write to string
		 String json = mapper.writeValueAsString(student);
		 //Write to output
		 mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
		 // write to file
		 mapper.writeValue(new File("C:\\Users\\Admin\\Desktop\\Java6_02112023\\Huyndph17533_JAVA6\\Java6_Bai1\\src\\main\\resources\\testaddjson.json"), student);
	}

// Tạo dữ liệu vào json bằng Map
	private static void demo6() throws Exception {
		Map<String, Object> contact = new HashMap<String, Object>();
		contact.put("email", "thukm@gmail.com");
		contact.put("phone", "034567889");
		
		List<String> subjects = Arrays.asList("WEB205", "COM108");
		Map<String, Object> student = new HashMap<String, Object>();
		student.put("name", "Khổng Minh Thu");
		student.put("marks", 9.9);
		student.put("gender", true);
		student.put("contact", contact);
		
		ObjectMapper mapper = new ObjectMapper();
		// write to string
		String json = mapper.writeValueAsString(student);
		System.out.println(json);
		// write to output
		mapper.writeValue(System.out, student);
		// write to file
		mapper.writeValue(new File("C:\\Users\\Admin\\Desktop\\Java6_02112023\\Huyndph17533_JAVA6\\Java6_Bai1\\src\\main\\resources\\testaddjson.json"), student);
	}

// Tạo dữ liệu vào json bằng JsonNode
	private static void demo5() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode student = mapper.createObjectNode();
		 student.put("name", "Nguyễn Đức Huy");
		 student.put("marks", 7.5);
		 student.put("gender", true);
		 ObjectNode contact = student.putObject("contact");
		 contact.put("email", "huynguyen@gmail.com");
		 contact.put("phone", "09999999999");
		 ArrayNode subjects = student.putArray("subjects");
		 subjects.add("WEB205");
		 subjects.add("COM108");
		 
		 // write to string
		 String json = mapper.writeValueAsString(student);
		 //Write to output
		 mapper.writeValue(System.out, student);
		 // write to file
		 mapper.writeValue(new File("C:\\Users\\Admin\\Desktop\\Java6_02112023\\Huyndph17533_JAVA6\\Java6_Bai1\\src\\main\\resources\\testaddjson.json"), student);
	}

// 	dùng Lớp do mk mô tả
	private static void demo4() throws Exception {
		String path = "C:\\Users\\Admin\\Desktop\\Java6_02112023\\Huyndph17533_JAVA6\\Java6_Bai1\\src\\main\\resources\\students.json";
		// dùng type thay cho class
		TypeReference<List<Student2>> type = new TypeReference<>() {}; // chú ý thư viện
		ObjectMapper mapper = new ObjectMapper();
		List<Student2> students = mapper.readValue(new File(path), type);
		students.forEach(student -> {
			System.err.println(">>Name: " + student.getName());
		});

	}
// 	dùng Lớp do mk mô tả
	private static void demo3() throws Exception {
		String path = "C:\\Users\\Admin\\Desktop\\Java6_02112023\\Huyndph17533_JAVA6\\Java6_Bai1\\src\\main\\resources\\student.json";
		ObjectMapper mapper = new ObjectMapper();
		// chuyển chuỗi thành JsonNode
		Student2 student = mapper.readValue(new File(path), Student2.class);
		// lấy từng Node con ra chuyển sang kiểu DL mong muốn
		System.out.println(">>Name: " + student.getName());
		System.out.println(">>Marks: " + student.getMarks());
		System.out.println(">>Gender: " + student.getGender());
		Contact contact = student.getContact();
		System.out.println(">>Email: " + contact.getEmail());
		System.out.println(">>Phone: " +contact.getPhone());
		List<String> subjects = (List<String>) student.getSubjects();
		subjects.forEach(subject -> {
			System.out.println(">>Subject: " + subject);
		});
		
	}
// 	dùng Map
	private static void demo2() throws Exception {
		String path = "C:\\Users\\Admin\\Desktop\\Java6_02112023\\Huyndph17533_JAVA6\\Java6_Bai1\\src\\main\\resources\\students.json";
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
		students.forEach(student -> {
			System.err.println(">>Name: " + student.get("name"));
		});
		
	}
// 	dùng Map
	private static void demo1() throws Exception{
		String path = "C:\\Users\\Admin\\Desktop\\Java6_02112023\\Huyndph17533_JAVA6\\Java6_Bai1\\src\\main\\resources\\student.json";
		ObjectMapper mapper = new ObjectMapper();
		// chuyển chuỗi thành JsonNode
		Map<String, Object> student = mapper.readValue(new File(path), Map.class);
		// lấy từng Node con ra chuyển sang kiểu DL mong muốn
		System.out.println(">>Name: " + student.get("name"));
		System.out.println(">>Marks: " + student.get("marks"));
		System.out.println(">>Gender: " + student.get("gender"));
		Map<String, Object> contact = (Map<String, Object>) student.get("contact");
		System.out.println(">>Email: " + contact.get("email"));
		System.out.println(">>Phone: " +contact.get("phone"));
		List<String> subjects = (List<String>) student.get("subjects");
		subjects.forEach(subject -> {
			System.out.println(">>Subject: " + subject);
		});
	}
}
