package gr.constantina.home.collegeWithSpring.model;

import gr.constantina.home.collegeWithSpring.repository.AchievedMarks;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MarkModule {
    private int stId;
    private Module module;
    private AchievedMarks achievedMarks;
    private double tempMark;

    public MarkModule(int stId, Module module, AchievedMarks achievedMarks) {
        this.stId = stId;
        this.module = module;
        this.achievedMarks = achievedMarks;
    }

    public MarkModule(Module m) {
    }

    public void setTempMark(){
        tempMark =  achievedMarks
                .getAchievedMarks()
                .stream()
                .mapToInt(AchievedMark::getMark)
                .max()
                .orElse(0);
    }
}
