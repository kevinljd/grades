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

    private App() {
        db = new Database();
        currentSem = db.getSemester(getCurrentYear(), getCurrentSem());
        kb = new Scanner(System.in);
    }

    private int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    private int getCurrentSem() {
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
            addAssessment();
        } else if (choice == 2) {
            inspectAssessment();
        } else if (choice == 3) {
            deleteAssessment();
        }


    }

    public static void main(String[] args) {
        App app = new App();
        while(true) {

        }
    }
}
