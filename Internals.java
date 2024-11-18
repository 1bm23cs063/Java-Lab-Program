package CIE;

public class Internals {
    public int[] internalMarks = new int[5];

    public void setInternalMarks(int[] marks) {
        if (marks.length == 5) {
            System.arraycopy(marks, 0, internalMarks, 0, marks.length);
        } else {
            System.out.println("Error: Exactly 5 internal marks are required.");
        }
    }

    public int[] getInternalMarks() {
        return internalMarks;
    }
}
