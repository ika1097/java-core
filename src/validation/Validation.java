package validation;

import exception.MyException;
import viser.Course;
import viser.Student;

public class Validation {
    public static Student validateStudent(String line) throws MyException {
        String[] data = line.split(",");
        char[] c = data[3].toCharArray();

        try {
            if (data.length < 5) throw new MyException("Imate manje od 5 podatka");

            try {
                Integer.parseInt(data[0]);
            } catch (Exception e) {
                throw new MyException("Id nije ceo broj!");
            }

            if (!data[3].contains("@"))
                throw new MyException("Nije dobar format za email!");

            if (!data[4].equals("Male") && !data[4].equals("Female")) throw new MyException("Neispravan pol");
        } catch (Exception e) {
            System.out.println("Greska " + e);
            return null;
        }
        return new Student(Integer.parseInt(data[0]),
                                            data[1],
                                            data[2],
                                            data[3],
                                            data[4].equals("Male") ? true : false);
    }

    public static Course validateCourse(String line) throws MyException {
        String[] data = line.split(",");

        try {
            if (data.length < 5) throw new MyException("Imate manje od 5 podatka");

            try {
                Integer.parseInt(data[0]);
            } catch (Exception e) {
                throw new MyException("Id nije ceo broj!");
            }

            try {
                Integer.parseInt(data[1]);
            } catch (Exception e) {
                throw new MyException("Id studenta nije ceo broj!");
            }

            try {
                Integer.parseInt(data[2]);
            } catch (Exception e) {
                throw new MyException("Ocena nije ceo broj!");
            }

            try {
                Integer.parseInt(data[3]);
            } catch (Exception e) {
                throw new MyException("Semestar nije ceo broj!");
            }

            try {
                Integer.parseInt(data[4]);
            } catch (Exception e) {
                throw new MyException("ESPB bodovi nisu ceo broj!");
            }

            int x = Integer.parseInt(data[2]);
            if (x < 5 || x > 10) throw new MyException("Neispravna ocena");

        } catch (Exception e) {
            System.out.println("Greska " + e);
        }

        return new Course(Integer.parseInt(data[0]),
                            Integer.parseInt(data[1]),
                            Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]),
                            Integer.parseInt(data[4]));
    }
}