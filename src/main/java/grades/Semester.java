package grades;

import java.util.ArrayList;
import java.util.HashMap;

public class Semester {
//    private ArrayList<Course> courses;
    private HashMap<String, Course> courses;
    private int year;
    private int semester;

    public Semester(int year, int semester) {
        this.year = year;
        this.semester = semester;
        this.courses = new HashMap<>();
    }

    public boolean checkIfCourseExist(String name) {
        return courses.containsKey(name);
    }

    public void addCourse(String name) {
        this.courses.put(name, new Course(name));
    }
    public void deleteCourse(String name) {
        this.courses.remove(name);
    }

    public Course getCourse(String name) {
        return courses.get(name);
    }

    public int getCoursesSize() {
        return this.courses.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(year);
        str.append(" S");
        str.append(semester);
        str.append(" courses: \n");
        int i = 0;
        for (Course c : courses.values()) {
            str.append(i + 1);
            str.append(". ");
            str.append(c.getCourseCode());
            str.append("\n");
            i++;
        }
        return str.toString();
    }

}
