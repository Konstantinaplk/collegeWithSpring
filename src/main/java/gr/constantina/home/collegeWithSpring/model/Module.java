package gr.constantina.home.collegeWithSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    private String name;
    private Course course;
    private String tutorName;
    private ModuleType moduleType;

    public Module(String name, String tutorName) {
        this.name = name;
        this.tutorName = tutorName;
    }
}
