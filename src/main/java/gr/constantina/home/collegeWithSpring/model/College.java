package gr.constantina.home.collegeWithSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {
    private String name;
    private List<Student> students;
}
