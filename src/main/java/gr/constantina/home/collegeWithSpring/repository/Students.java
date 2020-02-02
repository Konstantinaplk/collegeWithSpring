package gr.constantina.home.collegeWithSpring.repository;

import gr.constantina.home.collegeWithSpring.model.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Students {
    private List<Student> students;

    public Students() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s){
        students.add(s);
    }
}
