package java6bai2.java6_bai2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperatorController {

	@RequestMapping("/demo/operator")
	public String demo(Model model) {
		model.addAttribute("x", 14);
		model.addAttribute("y", 29);
		return "operator";
	}
}
