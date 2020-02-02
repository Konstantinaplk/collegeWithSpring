package gr.constantina.home.collegeWithSpring.controller;

import gr.constantina.home.collegeWithSpring.model.Module;
import gr.constantina.home.collegeWithSpring.model.Student;
import gr.constantina.home.collegeWithSpring.repository.Modules;
import gr.constantina.home.collegeWithSpring.repository.Students;
import gr.constantina.home.collegeWithSpring.services.StudentsReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class StudentsController {
    @GetMapping("student/{id}")
    public Student studentByIdContoller(@PathVariable int id) throws FileNotFoundException {
        StudentsReader studentsReader = new StudentsReader();

        return studentsReader.getStudentsById(id);
    }

    @GetMapping("student/{id}/{moduleName}")
    public Module modulesByIdAndNameContoller(@PathVariable int id, @PathVariable String  moduleName) throws FileNotFoundException {
        StudentsReader studentsReader = new StudentsReader();
        return studentsReader.getModulesByStIdAndNameOfModule(id, moduleName);
    }


}
