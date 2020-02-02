package gr.constantina.home.collegeWithSpring.services;

import gr.constantina.home.collegeWithSpring.model.Course;
import gr.constantina.home.collegeWithSpring.model.MarkModule;
import gr.constantina.home.collegeWithSpring.model.Module;
import gr.constantina.home.collegeWithSpring.model.ModuleType;
import gr.constantina.home.collegeWithSpring.repository.Courses;
import gr.constantina.home.collegeWithSpring.repository.MarkModules;
import gr.constantina.home.collegeWithSpring.repository.Modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MarkedModuleReader {
    Modules modules = new Modules();
    public MarkModules readMarkModules(String filename) throws FileNotFoundException {
        MarkModules mm = new MarkModules();
        Scanner scanner = new Scanner(new File(filename));
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String [] words = line.split(",");
            MarkModule m = new MarkModule();
            m.setStId(Integer.parseInt(words[0].trim()));
            m.setModule(modules.getModuleByName("module1.csv", words[1].trim()));
            AchievedMarkReader amr = new AchievedMarkReader();
            m.setAchievedMarks(amr.readAchievedMark("achievedmark1.csv"));
            mm.addMarkModule(m);
            m.setTempMark();
        }
        scanner.close();
        return mm;
    }



}
