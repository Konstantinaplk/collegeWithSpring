package gr.constantina.home.collegeWithSpring.services;

import gr.constantina.home.collegeWithSpring.model.AchievedMark;
import gr.constantina.home.collegeWithSpring.repository.AchievedMarks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AchievedMarkReader {
    public AchievedMarks readAchievedMark(String filename) throws FileNotFoundException {
        AchievedMarks ams = new AchievedMarks();
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNext()){
            String line = sc.nextLine();
            String [] words = line.split(",");
            AchievedMark am = new AchievedMark(words[0].trim(), Integer.parseInt(words[1].trim()));
            ams.addAchievedMarks(am);
        }
        sc.close();
        return ams;
    }
}
