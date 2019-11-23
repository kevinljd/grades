package grades;

import java.util.ArrayList;

public class Semester {
    private ArrayList<Course> courses;
    private int year;
    private int semester;

    public Semester(int year, int semester) {
        this.year = year;
        this.semester = semester;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String name) {
        this.courses.add(new Course(name));
    }

}
