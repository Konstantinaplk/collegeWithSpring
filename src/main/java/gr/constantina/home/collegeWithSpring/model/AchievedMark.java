package gr.constantina.home.collegeWithSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AchievedMark {
    private String date;
    private int mark;
}
