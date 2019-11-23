package grades;

import java.util.ArrayList;

public class Course {
    private String courseCode;
    private ArrayList<Assessment> assessments;

    public Course(String courseCode) {
        this.courseCode = courseCode;
        this.assessments = new ArrayList<>();
    }

    public void addAssessment(Assessment a) {
        this.assessments.add(a);
    }

    public int unaccountedWeighting() {
        int unaccounted = 0;
        for (Assessment a : assessments) {
            unaccounted += a.getWeighting();
        }
        return unaccounted;
    }

    public String examGoals() {
        Double ninety = 90.0;
        Double hd = 85.0;
        Double d = 75.0;

        int fullMark = 100;

        double marksAttainedSoFar = 0;
        Assessment finalExam = null;

        for (Assessment a: assessments) {
            marksAttainedSoFar += a.markNormalised();
            if (a.getName().toLowerCase().equals("final")) {
                finalExam = a;
            }
        }

        ninety -= marksAttainedSoFar;
        hd -= marksAttainedSoFar;
        d -= marksAttainedSoFar;

        if (ninety > finalExam.getWeighting()) {
            ninety = null;
            if (hd > finalExam.getWeighting()) {
                hd = null;
                if (d > finalExam.getWeighting()) {
                    d = null;
                }
            }
        }

        StringBuilder str = new StringBuilder();
        str.append("Your Goals are \n");
        str.append("90: ");
        str.append(ninety);
        str.append("/");
        str.append(finalExam.getWeighting());
        str.append("\n");
        str.append("High Distinction: ");
        str.append(hd);
        str.append("/");
        str.append(finalExam.getWeighting());
        str.append("\n");
        str.append("Distinction: ");
        str.append(d);
        str.append("/");
        str.append(finalExam.getWeighting());
        str.append("\n");

        return str.toString();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(courseCode);
        str.append(": \n");
        for (int i = 0; i < assessments.size(); i++) {
            str.append(i + 1);
            str.append(". ");
            str.append(assessments.get(i).toString());
        }
        return str.toString();
    }
}
