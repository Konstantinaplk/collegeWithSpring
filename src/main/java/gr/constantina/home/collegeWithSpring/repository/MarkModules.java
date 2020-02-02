package gr.constantina.home.collegeWithSpring.repository;

import gr.constantina.home.collegeWithSpring.model.Course;
import gr.constantina.home.collegeWithSpring.model.MarkModule;
import gr.constantina.home.collegeWithSpring.services.MarkedModuleReader;
import lombok.Data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Data
public class MarkModules {
    private List<MarkModule> markModules;

    public MarkModules() {
        this.markModules = new ArrayList<>();
    }

    public void addMarkModule(MarkModule m){
        markModules.add(m);
    }

    public Course getCourseFromMarkModulesById(String filename, int id) throws FileNotFoundException {
        MarkModules markModules = new MarkModules();
        MarkedModuleReader markedModuleReader = new MarkedModuleReader();
        markModules = markedModuleReader.readMarkModules("markedModules.csv");
        return markModules
                .getMarkModuleFromId("MarkedModules.csv", id)
                .getModule()
                .getCourse()
                ;
    }

    public MarkModule getMarkModuleFromId(String filename, int id) throws FileNotFoundException {
        MarkModules markModules = new MarkModules();
        MarkedModuleReader markedModuleReader = new MarkedModuleReader();
        markModules = markedModuleReader.readMarkModules("markedModules.csv");
        return markModules
                .getMarkModules()
                .stream()
                .filter(markModule -> markModule.getStId()==id)
                .findFirst()
                .orElse(markModules.getMarkModules().get(0))
                ;
    }
}
