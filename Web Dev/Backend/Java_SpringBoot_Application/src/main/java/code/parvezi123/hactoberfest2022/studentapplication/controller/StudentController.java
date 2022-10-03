package code.parvezi123.hactoberfest2022.studentapplication.controller;


import code.parvezi123.hactoberfest2022.studentapplication.entity.Student;
import code.parvezi123.hactoberfest2022.studentapplication.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/allstudents")
    public List<Student> retrieveStudentList() {
        return studentService.retrieveStudentList();
    }

    @PostMapping("/savestudent")
    public String saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

}
