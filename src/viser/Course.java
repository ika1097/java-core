package viser;

public class Course {
    private int id;
    private int id_student;
    private int mark;
    private int semester;
    private int espb;

    public Course(int id, int id_student, int mark, int semester, int espb) {
        this.id = id;
        this.id_student = id_student;
        this.mark = mark;
        this.semester = semester;
        this.espb = espb;
    }

    public Course() {
        id = 0;
        id_student = 0;
        mark = 0;
        semester = 0;
        espb = 0;
    }

    public int getMark() {
        return mark;
    }

    public int getEspb() {
        return espb;
    }

    public int getId_student() {
        return id_student;
    }

    @Override
    public String toString() {
        return "Ocena: " + mark + " - espb: " + espb + "- semestar: " + semester;
    }
}