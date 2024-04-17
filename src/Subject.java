import java.util.ArrayList;

public class Subject {
    String name;
    ArrayList<Integer> grades = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }
}
