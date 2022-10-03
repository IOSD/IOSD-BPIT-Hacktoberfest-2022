package code.parvezi123.hactoberfest2022.studentapplication.repository;


import code.parvezi123.hactoberfest2022.studentapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {



}
