class BMSCollegeThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("BMS College of Engineering");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted: " + ie);
            }
        }
    }
}

class CSEThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("CSE");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted: " + ie);
            }
        }
    }
}

public class MyThread {
    public static void main(String[] args) {
        BMSCollegeThread t1 = new BMSCollegeThread();
        CSEThread t2 = new CSEThread();
        
        t1.start();
        t2.start();
    }
}
