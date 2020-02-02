package gr.constantina.home.collegeWithSpring.repository;

import gr.constantina.home.collegeWithSpring.model.Course;
import gr.constantina.home.collegeWithSpring.model.Module;
import gr.constantina.home.collegeWithSpring.services.CoursesReader;
import gr.constantina.home.collegeWithSpring.services.ModulesReader;
import lombok.Data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data

public class Modules {
    private List<Module> modules;

    public Modules() {
        this.modules = new ArrayList<>();
    }

    public void addModules(Module m) {
        modules.add(m);
    }

    public Module getModuleByName(String filename, String name) throws FileNotFoundException {
        ModulesReader mr = new ModulesReader();
        Modules modules = mr.readModules(filename);
        return modules.getModules()
                .stream()
                .filter(module -> Objects.equals(module.getName(), name))
                .findFirst()
                .orElse(new Module())
                ;
    }
}
