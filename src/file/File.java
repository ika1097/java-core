package file;

import exception.MyException;
import validation.Validation;
import viser.Course;
import viser.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static validation.Validation.validateCourse;
import static validation.Validation.validateStudent;

public class File {
    public static ArrayList<Student> readStudent() throws FileNotFoundException, IOException, MyException {
        ArrayList<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("Student.txt");
            Scanner s = new Scanner(fis);

            while (s.hasNextLine()) {
                String str = s.nextLine();
                if (Validation.validateStudent(str) != null) {
                    students.add(validateStudent(str));
                }
            }
            s.close();
            fis.close();
        } catch (FileNotFoundException ex ) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

    public static ArrayList<Course> readCourse() throws FileNotFoundException, IOException, MyException {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("Predmet.txt");
            Scanner s = new Scanner(fis);

            while (s.hasNextLine()) {
                String str = s.nextLine();
                courses.add(validateCourse(str));
            }
            s.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }

        return courses;
    }
}