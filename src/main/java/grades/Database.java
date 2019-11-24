package grades;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
//    private ArrayList<Semester> semesters;
    private HashMap<Integer, Semester[]> semesters;

    public Database() {
        semesters = new HashMap<>();
    }

    private boolean checkIfSemesterExists(int year, int semester) {
        int semIndex = semester - 1;

        if (semesters.containsKey(year)) {
            if (semesters.get(year)[semIndex] != null) {
                return true;
            }
        } else {
            semesters.put(year, new Semester[2]);
        }

        return false;
    }

    private boolean createSemester(int year, int semester) {
        int semIndex = semester - 1;

        if (!checkIfSemesterExists(year, semester)) {
            semesters.get(year)[semIndex] = new Semester(year, semester);
            return true;
        }

//        semesters.get(year)[semIndex] = new Semester(year, semester);
        return false;
//        return true;
    }

    public Semester getSemester(int year, int semester) {
        int semIndex = semester - 1;
        Semester sem = null;
        if (checkIfSemesterExists(year, semester)) {
            sem = semesters.get(year)[semIndex];
        } else {
            createSemester(year, semester);
            sem = semesters.get(year)[semIndex];
        }
        return sem;
    }

//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder();
//        str.append("All semesters stored: \n");
//        str.append("All semesters stored: \n");
//        for (int i = 0; i < assessments.size(); i++) {
//            str.append(i + 1);
//            str.append(". ");
//            str.append(assessments.get(i).toString());
//        }
//        return str.toString();
//    }
}
