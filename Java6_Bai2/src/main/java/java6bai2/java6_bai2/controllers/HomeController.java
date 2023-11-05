package java6bai2.java6_bai2.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java6bai2.java6_bai2.beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
public class HomeController {
	@RequestMapping("/home/index")
	public String index(Model model) throws Exception {
		model.addAttribute("message", "Welcome to Thymeleaf");
		ObjectMapper mapper = new ObjectMapper();
		String path = "C:\\Users\\Admin\\Desktop\\Java6_02112023\\Huyndph17533_JAVA6\\Java6_Bai2\\src\\main\\resources\\static\\student.json";
		Student student = mapper.readValue(new File(path), Student.class);
		model.addAttribute("sv", student);
		return "home/index";
	}
}
