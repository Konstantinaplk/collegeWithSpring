package gr.constantina.home.collegeWithSpring.services;
import gr.constantina.home.collegeWithSpring.model.Course;
import gr.constantina.home.collegeWithSpring.model.Module;
import gr.constantina.home.collegeWithSpring.model.ModuleType;
import gr.constantina.home.collegeWithSpring.repository.Courses;
import gr.constantina.home.collegeWithSpring.repository.Modules;
import lombok.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Data
public class ModulesReader {
    Courses c = new Courses();
    public Modules readModules(String filenames) throws FileNotFoundException {
        Modules modules = new Modules();
        Scanner scanner = new Scanner(new File(filenames));
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String [] words = line.split(",");
            Module m = new Module();
            m.setModuleType(ModuleType.valueOf(words[3].trim()));
            Course temp = new Course();
            temp = c.getCourseByName("courses.csv", words[1].trim());
            m.setCourse(temp);
            m.setName(words[0]);
            m.setTutorName(words[2]);
            modules.addModules(m);
        }
        scanner.close();
        return modules;
    }
}
