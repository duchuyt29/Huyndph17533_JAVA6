package java6bai3.java6_bai3.controllers;


import java6bai3.java6_bai3.beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
//video 3.2 looix
    @RequestMapping("/student/form")
    public String form(Model model) {
        Student student = new Student();
        model.addAttribute("stu", student);
//        student.setFullName("Nguyễn Đức Huy");
//        student.setCountry("VN");
//        student.setGender(true);
//        model.addAttribute("sv",student);

        return  "student/form";
    }

//    @RequestMapping("/student/form")
//    public String form(Model model) {
//        Student2 student = new Student2();
//        student.setFullName("Nguyễn Đức Huy");
//        student.setCountry("VN");
//        student.setGender(true);
//        model.addAttribute("sv",student);
//
//        return  "student/form";
//    }

    @PostMapping("/student/save")
    public String save(@ModelAttribute("sv") Student form){
        return "student/success";
    }

//    @PostMapping("/student/save")
//    public String save(
//            Model model,
//            @Validated @ModelAttribute("sv") Student2 form,
//            Errors errors
//    ) {
//        if (errors.hasErrors()) {
//            model.addAttribute("message", "Vui lòng sửa các lỗi sau");
//            return "student/form";
//        }
//        return "student/success";
//    }
}
