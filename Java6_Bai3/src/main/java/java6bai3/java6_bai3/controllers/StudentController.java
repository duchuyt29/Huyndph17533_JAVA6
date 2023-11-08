package java6bai3.java6_bai3.controllers;


import java6bai3.java6_bai3.beans.Student;
import java6bai3.java6_bai3.beans.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {
//video 3.2 looix
    @GetMapping("/student/form")
    public String form(Model model) {
        Student student = new Student();
        model.addAttribute("stu", student);
        student.setFullName("Nguyễn Đức Huy");
        student.setCountry("VN");
        student.setGender(true);

        return  "student/form";
    }

    @PostMapping("/student/save")
    public String save(@ModelAttribute("sv") Student form){
        return "student/success";
    }

    @GetMapping("/validate/form")
    public String validform(Model model){
        Student2 student2 = new Student2();
        model.addAttribute("stuval", student2);
        return "validateStu/form";
    }

    @PostMapping("/validate/save")
    public String validsave(Model model, @Validated @ModelAttribute("stuval") Student2 validform, Errors errors){
//        var studen = validform;

        if(errors.hasErrors()){
            model.addAttribute("message", "Vui lòng sửa các lỗi sau");
            return "validateStu/form";
        }


        return "validateStu/success";
    }


}
