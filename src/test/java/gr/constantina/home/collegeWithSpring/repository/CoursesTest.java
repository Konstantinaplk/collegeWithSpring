package gr.constantina.home.collegeWithSpring.repository;

import gr.constantina.home.collegeWithSpring.model.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CoursesTest {
    private Courses courses;
    private Course course;
    private Course c2;

    @BeforeEach
    void setUp() {
        course = new Course("Mech", "NTUA", "dhjsjh");
        courses = new Courses();
        c2 = new Course("Development", "ATC", "SEPT_2020_JUN_2021");

    }



    @AfterEach
    void tearDown() {
    }

    @Test
    void addCourse() {
       assertEquals(true, courses.addCourse(course));
    }

    @Test
    void getCourseByName() throws FileNotFoundException {
        assertEquals(c2, courses.getCourseByName("courses.csv", "Development"));
    }

    @Test
    void getCourses() {
    }

    @Test
    void setCourses() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}