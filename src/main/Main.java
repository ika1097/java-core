package main;

import exception.MyException;
import file.File;
import viser.Course;
import viser.Student;
import viser.Useful;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException, MyException {
        ArrayList<Course> courses = File.readCourse();
        ArrayList<Student> students = File.readStudent();

        students = Useful.arrange(courses, students);

        students = Useful.rank(students);

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}