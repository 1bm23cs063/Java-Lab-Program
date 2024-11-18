package SEE;

import CIE.Student;

public class External extends Student {
    public int[] externalMarks = new int[5];

    public External(String usn, String name, int sem) {
        super(usn, name, sem);
    }

    public void setExternalMarks(int[] marks) {
        if (marks.length == 5) {
            System.arraycopy(marks, 0, externalMarks, 0, marks.length);
        } else {
            System.out.println("Error: Exactly 5 external marks are required.");
        }
    }

    public int[] getExternalMarks() {
        return externalMarks;
    }
}

