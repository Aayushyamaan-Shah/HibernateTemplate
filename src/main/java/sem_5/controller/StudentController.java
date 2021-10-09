package sem_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sem_5.model.Student;
import sem_5.service.StudentService;

@Controller
public class StudentController {


    public StudentService studentService;

    @Autowired
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping (value = "/list_student", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("student",new Student());
        model.addAttribute("listStudents", this.studentService.listStudents());
        return "student";
    }


    @RequestMapping(value= "/student/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student p){

        //existing person, call update
        this.studentService.updateStudent(p);
        return "redirect:/list_student";
    }


}
