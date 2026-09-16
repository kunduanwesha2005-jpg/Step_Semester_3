package constructors.class_problems;

class SrmStudent {
    static String collegeName;
    static String academicYear;
    String name;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2025-2026";
        System.out.println("College info loaded");
    }

    SrmStudent(String name) {
        this.name = name;
    }
}

public class M4_SrmStudent {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String name : names) {
            SrmStudent student = new SrmStudent(name);
            System.out.println("Student record created: " + student.name);
        }
    }
}