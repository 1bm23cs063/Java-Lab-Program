import CIE.*;
import SEE.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        External[] students = new External[n];
        Internals[] internalsMarks = new Internals[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter USN for student " + (i + 1) + ": ");
            String usn = sc.nextLine();
            System.out.print("Enter Name for student " + (i + 1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter Semester for student " + (i + 1) + ": ");
            int sem = sc.nextInt();

            students[i] = new External(usn, name, sem);
            internalsMarks[i] = new Internals();

            System.out.println("Enter internal marks for 5 courses:");
            int[] iMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                iMarks[j] = sc.nextInt();
            }
            internalsMarks[i].setInternalMarks(iMarks);

            System.out.println("Enter external marks for 5 courses:");
            int[] eMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                eMarks[j] = sc.nextInt();
            }
            students[i].setExternalMarks(eMarks);

            sc.nextLine(); 
        }

        System.out.println("\nFinal Marks of Students:");
        for (int i = 0; i < n; i++) {
            students[i].displayPersonalInfo();
            int[] iMarks = internalsMarks[i].getInternalMarks();
            int[] eMarks = students[i].getExternalMarks();

            System.out.print("Final Marks in 5 courses: ");
            for (int j = 0; j < 5; j++) {
                int finalMark = iMarks[j] + eMarks[j];
                System.out.print(finalMark + " ");
            }
            System.out.println("\n");
        }
        sc.close();
    }
}
