package CIE;

public class Student {
    public String usn;
    public String name;
    public int sem;

    public Student(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }

    public void displayPersonalInfo() {
        System.out.println("USN: " + usn + ", Name: " + name + ", Semester: " + sem);
    }
}
