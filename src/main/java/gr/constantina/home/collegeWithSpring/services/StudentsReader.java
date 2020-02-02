package gr.constantina.home.collegeWithSpring.services;

import gr.constantina.home.collegeWithSpring.model.MarkModule;
import gr.constantina.home.collegeWithSpring.model.Module;
import gr.constantina.home.collegeWithSpring.model.Student;
import gr.constantina.home.collegeWithSpring.repository.MarkModules;
import gr.constantina.home.collegeWithSpring.repository.Modules;
import gr.constantina.home.collegeWithSpring.repository.Students;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentsReader {
    public Students readStudents(String filename) throws FileNotFoundException {
        Students students = new Students();
        Scanner scanner = new Scanner(new File(filename));
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String [] words = line.split(",");
            Student student = new Student();
            student.setId(Integer.parseInt(words[0].trim()));
            student.setName(words[1].trim());
            student.setAddress(words[2].trim());
            MarkModules mm = new MarkModules();
            student.setCourse(mm.getCourseFromMarkModulesById("MarkedModules1.csv", Integer.parseInt(words[0].trim())));
            student.setMarkModules(Collections.singletonList(mm.getMarkModuleFromId("MarkedModules.csv", Integer.parseInt(words[0].trim()))));
            students.addStudent(student);
        }
        scanner.close();
        return students;
    }

    public Student getStudentsById(int id) throws FileNotFoundException {
        StudentsReader studentsReader = new StudentsReader();
        Students students;
        students = studentsReader.readStudents("students.csv");
        return students.getStudents().stream().filter(student -> student.getId() == id).findFirst().get();
    }

    public Module getModulesById(int id) throws FileNotFoundException {
        MarkedModuleReader markedModuleReader = new MarkedModuleReader();
        return markedModuleReader.readMarkModules("markedModules.csv").getMarkModuleFromId("markedModules.csv", id).getModule();
    }

    public Module getModulesByStIdAndNameOfModule(int id, String moduleName) throws FileNotFoundException {
        StudentsReader studentsReader = new StudentsReader();
        return studentsReader.getStudentsById(id).getMarkModules().stream().filter(markModule -> markModule.getModule().getName().equals(moduleName)).findFirst().orElse(new MarkModule()).getModule();
    }
}
