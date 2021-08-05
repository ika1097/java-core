package viser;

import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String email;
    private boolean gender;
    private ArrayList<Course> courses;

    public Student(int id, String name, String surname, String email, boolean gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        courses = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        if (gender)
            return "Id: " + id + " - ime i prezime: " + name + " " + surname + "- email: " + email + "- pol: musko" + "- lista predmeta: " + getCourses();
        else
            return "Id: " + id + " - ime i prezime: " + name + " " + surname + "- email: " + email + "- pol: zensko" + "- lista predmeta: " + getCourses();

    }

    public void addCourse(Course p) {
        courses.add(p);
    }

    public double average() {
        ArrayList<Course> courses = getCourses();
        double average = 0;
        int sumOfCourses = 0;

        for (Course course : courses) {
            if (course.getMark() > 5) {
                average += course.getMark();
                sumOfCourses++;
            }
        }

        return average / sumOfCourses;
    }

    public int numESPB() {
        ArrayList<Course> courses = getCourses();
        int sumESPB = 0;

        for (Course course : courses) {
            if (course.getMark() > 5) {
                sumESPB += course.getEspb();
            }
        }

        return sumESPB;
    }
}