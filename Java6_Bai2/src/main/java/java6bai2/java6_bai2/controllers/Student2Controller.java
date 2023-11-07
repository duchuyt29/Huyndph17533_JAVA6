package java6bai2.java6_bai2.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java6bai2.java6_bai2.beans.Student;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
public class Student2Controller {

	@RequestMapping("/student/list")
	public String list(
		Model model,
		@RequestParam("index") Optional<Integer> index
	) throws Exception {
//		File file = ResourceUtils.getFile("C:\\Users\\Admin\\Desktop\\Java6_02112023\\Huyndph17533_JAVA6\\Java6_Bai2\\src\\main\\resources\\static\\students.json");
		File file = new ClassPathResource("static/students.json").getFile();
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Student>> type = new TypeReference<List<Student>>() {};
		List<Student> list = mapper.readValue(file, type);
		
		model.addAttribute("sv", list.get(index.orElse(0)));
		model.addAttribute("dssv", list);
		return "student2/list";
	}
}
