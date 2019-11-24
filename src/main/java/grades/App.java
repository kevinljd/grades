/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package grades;

import java.util.Calendar;
import java.util.Scanner;

public class App {

    private Database db;
    private Semester currentSem;
    private Scanner kb;

    public App() {
        db = new Database();
        currentSem = db.getSemester(getCurrentYear(), getCurrentSem());
        kb = new Scanner(System.in);
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public int getCurrentSem() {
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int sem;
        if (month >= 7) {
            sem = 2;
        } else {
            sem = 1;
        }
        return sem;
    }

    private Database getDB() {
        return db;
    }

    public void semesterOptions() {
        System.out.println(currentSem.toString());
        System.out.println();
        int choice;
        do {
            System.out.println("1 - Add a course");
            System.out.println("2 - Choose a course");
            System.out.println("3 - Delete a course");
            System.out.println("Select your options: ");
            choice = kb.nextInt();
        } while (choice != 1 && choice != 2 && choice != 3);

        if (choice == 1) {
            addCourse();
        } else if (choice == 2) {
            inspectCourse();
        } else if (choice == 3) {
            deleteCourse();
        }

    }

    public void addCourse() {
        System.out.println();
        System.out.println("Enter the course code: ");
        String courseCode = kb.nextLine().toLowerCase();
        currentSem.addCourse(courseCode);
        System.out.println(courseCode + " added.");
    }

    public void deleteCourse() {
        String courseCode;
        System.out.println();

        if (currentSem.getCoursesSize() < 1) {
            System.out.println("There are no courses stored.");
            return;
        }

        do {
            System.out.println("Enter the course code: ");
            courseCode = kb.nextLine().toLowerCase();
        } while (!currentSem.checkIfCourseExist(courseCode));
        currentSem.deleteCourse(courseCode);
        System.out.println(courseCode + " deleted.");
    }

    public void inspectCourse() {
        String courseCode;
        System.out.println();
        do {
            System.out.println("Enter the course code: ");
            courseCode = kb.nextLine().toLowerCase();
        } while (!currentSem.checkIfCourseExist(courseCode));
        Course course = currentSem.getCourse(courseCode);
        System.out.println();
        System.out.println(course.toString());
        System.out.println();

        int choice;
        do {
            System.out.println("1 - Add an assessment");
            System.out.println("2 - Choose an assessment");
            System.out.println("3 - Delete an assessment");
            System.out.println("Select your options: ");
            choice = kb.nextInt();
        } while (choice != 1 && choice != 2 && choice != 3);

        if (choice == 1) {
            addAssessment(course);
        } else if (choice == 2) {
            inspectAssessment(course);
        } else if (choice == 3) {
            deleteAssessment(course);
        }

    }

    public void addAssessment(Course course) {
        System.out.println();
        System.out.println("Enter the assessment name: ");
        String name = kb.nextLine().toLowerCase();
        System.out.println("Enter the max mark possible: ");
        int maxMark = kb.nextInt();
        System.out.println("Enter the mark you got: ");
        int mark = kb.nextInt();
        System.out.println("Enter the weighting: ");
        int weighting = kb.nextInt();
        course.addAssessment(new Assessment(name, maxMark, mark, weighting));
        System.out.println(name + " added.");
    }

    public void deleteAssessment(Course course) {
        int index;
        System.out.println();

        if (course.getAssessmentsSize() < 1) {
            System.out.println("There are no assessments stored.");
            return;
        }

        System.out.println(course.toString());
        do {
            System.out.println("Enter the index of the assessment to delete: ");
            index = kb.nextInt();
        } while (index > course.getAssessmentsSize() || index < 1);
        index--;
        Assessment deleted = course.deleteAssessment(index);
        System.out.println(deleted.getName() + " deleted.");
    }

    public void inspectAssessment(Course course) {
        int index;
        System.out.println();

        if (course.getAssessmentsSize() < 1) {
            System.out.println("There are no assessments stored.");
            return;
        }

        System.out.println(course.toString());
        do {
            System.out.println("Enter the index of the assessment to inspect: ");
            index = kb.nextInt();
        } while (index > course.getAssessmentsSize() || index < 1);
        index--;
        Assessment assessment = course.getAssessment(index);
        System.out.println();
        System.out.println(assessment.toString());
        System.out.println();

        int choice;
        do {
            System.out.println("1 - Edit the assessment name");
            System.out.println("2 - Edit the assessment mark");
            System.out.println("3 - Edit the assessment max mark");
            System.out.println("3 - Edit the assessment weighting");
            System.out.println("Select your options: ");
            choice = kb.nextInt();
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);

        if (choice == 1) {
            System.out.println();
            System.out.println("Enter the updated assessment name");
            String name = kb.nextLine();
            assessment.setName(name);
        } else if (choice == 2) {
            System.out.println();
            System.out.println("Enter the updated assessment mark");
            int mark = kb.nextInt();
            assessment.setMark(mark);
        } else if (choice == 3) {
            System.out.println();
            System.out.println("Enter the updated assessment max mark");
            int maxMark = kb.nextInt();
            assessment.setMaxMark(maxMark);
        } else if (choice == 4) {
            System.out.println();
            System.out.println("Enter the updated assessment weighting");
            int weighting = kb.nextInt();
            assessment.setWeighting(weighting);
        }


    }

    public static void main(String[] args) {
        App app = new App();
        while(true) {
            app.semesterOptions();
        }
    }
}
