package gr.constantina.home.collegeWithSpring.repository;

import gr.constantina.home.collegeWithSpring.model.Course;
import gr.constantina.home.collegeWithSpring.services.CoursesReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Courses {
    private List<Course> courses;



    public Courses() {
        this.courses = new ArrayList<>();
    }

    public boolean addCourse(Course c){
        courses.add(c);
        return true;
    }

    public Course  getCourseByName(String filename, String name) throws FileNotFoundException {
        CoursesReader cr = new CoursesReader();
        Courses courses = cr.readCourses(filename);
            return courses.getCourses()
                    .stream()
                    .filter(course -> Objects.equals(course.getName(), name))
                    .findFirst()
                    .orElse(courses.getCourses().get(3))
                    ;
    }
}
