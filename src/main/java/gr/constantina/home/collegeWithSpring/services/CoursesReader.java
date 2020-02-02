package gr.constantina.home.collegeWithSpring.services;

import gr.constantina.home.collegeWithSpring.model.Cohort;
import gr.constantina.home.collegeWithSpring.model.Course;
import gr.constantina.home.collegeWithSpring.repository.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Data
public class CoursesReader {

    public Courses readCourses(String filename) throws FileNotFoundException {
        Courses courses = new Courses();
        Scanner scanner = new Scanner(new File(filename));
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String [] words = line.split(",");
            Course c = new Course(words[0].trim(), words[1].trim(), words[2].trim());
            courses.addCourse(c);
        }
        scanner.close();
        return courses;
    }
}
