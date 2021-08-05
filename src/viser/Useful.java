package viser;

import java.util.ArrayList;

public class Useful {
    public static ArrayList<Student> rank(ArrayList<Student> students) {
        ArrayList<Student> ranked = new ArrayList<>();
        Student[] studentsArray = new Student[students.size()];
        int counter = students.size() - 1;

        for (Student student : students) {
            studentsArray[counter--] = student;
        }

        for (int i = 0; i < students.size(); ++i) {
            for (int j = i + 1; j < students.size(); ++j) {
                if (studentsArray[i].numESPB() < studentsArray[j].numESPB()) {
                    Student pom = studentsArray[i];
                    studentsArray[i] = studentsArray[j];
                    studentsArray[j] = pom;
                } else if (studentsArray[i].numESPB() == studentsArray[j].numESPB()) {
                    if (studentsArray[i].average() < studentsArray[j].average()) {
                        Student pom = studentsArray[i];
                        studentsArray[i] = studentsArray[j];
                        studentsArray[j] = pom;
                    } else if (studentsArray[i].average() == studentsArray[j].average()) {
                        if (studentsArray[i].getId() > studentsArray[j].getId()) {
                            Student pom = studentsArray[i];
                            studentsArray[i] = studentsArray[j];
                            studentsArray[j] = pom;
                        }
                    }
                }
            }
        }

        for (Student student : studentsArray) {
            ranked.add(student);
        }

        return ranked;
    }

    public static ArrayList<Student> arrange(ArrayList<Course> courses, ArrayList<Student> students) {
        for (Course course : courses)
            for (Student student : students) {
                if (course.getId_student() == student.getId())
                    student.addCourse(course);
            }

        return students;
    }
}