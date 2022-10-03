package code.parvezi123.hactoberfest2022.studentapplication.service;


import code.parvezi123.hactoberfest2022.studentapplication.entity.Student;
import code.parvezi123.hactoberfest2022.studentapplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> retrieveStudentList() {
        return studentRepository.findAll();
    }

    public String saveStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        if (savedStudent.getStudentId().equals(student.getStudentId()))
            return "Student Detail saved successfully";
        return "Student Failed to save";
    }
}
