package gr.constantina.home.collegeWithSpring.controller;

import gr.constantina.home.collegeWithSpring.model.MarkModule;
import gr.constantina.home.collegeWithSpring.model.Module;
import gr.constantina.home.collegeWithSpring.repository.*;
import gr.constantina.home.collegeWithSpring.services.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class CollegeController {

    @GetMapping
    public String empty(){
        return "<br><b>Welcome to College</b></Br>";
    }

    @GetMapping("courses")
    public Courses coursesController() throws FileNotFoundException {
        CoursesReader coursesReader = new CoursesReader();
        return coursesReader.readCourses("courses.csv");
    }
    @GetMapping("achievedmarks")
    public AchievedMarks achievedMarksController() throws FileNotFoundException {
        AchievedMarkReader AchievedMarksReader = new AchievedMarkReader();
        return AchievedMarksReader.readAchievedMark("achievedmark1.csv");
    }

    @GetMapping("modules")
    public Modules moduleContoller() throws FileNotFoundException {
        CoursesReader coursesReader = new CoursesReader();
        ModulesReader moduleReader = new ModulesReader();
        return moduleReader.readModules("module1.csv");
    }

    @GetMapping("markedModules")
    public MarkModules markModulesContoller() throws FileNotFoundException {
        MarkedModuleReader markedModuleReader = new MarkedModuleReader();

        return markedModuleReader.readMarkModules("markedModules.csv");
    }

    @GetMapping("students")
    public Students studentsContoller() throws FileNotFoundException {
        StudentsReader studentsReader = new StudentsReader();

        return studentsReader.readStudents("students.csv");
    }

}
