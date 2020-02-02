package gr.constantina.home.collegeWithSpring.model;

import gr.constantina.home.collegeWithSpring.repository.MarkModules;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private String address;
    private List<MarkModule> markModules;
    private Course course;


    public void addMarkModules(MarkModule m) {
        markModules.add(m);
    }

    public void enrollModule(Module m) {
        if (m.getCourse() == course) {
            markModules.add(new MarkModule(m));
        }
    }

    public void setMarkModules() {
    }

//    public double getAvgMark() {
//        if (!markModules.isEmpty()) {
//            return (markModules
//                    .stream()
//                    .mapToDouble(MarkModule::getTempMark)
//                    .sum()) / markModules.size();
//        } else {
//            return 0;
//        }
//    }
}
