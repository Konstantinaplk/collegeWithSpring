package gr.constantina.home.collegeWithSpring.repository;

import gr.constantina.home.collegeWithSpring.model.AchievedMark;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AchievedMarks {
    private List<AchievedMark> achievedMarks;

    public AchievedMarks() {
        this.achievedMarks = new ArrayList<>();
    }

    public void addAchievedMarks (AchievedMark a){
        achievedMarks.add(a);
    }
}
