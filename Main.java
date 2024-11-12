import java.util.*;

public class Main {
    public static void main(String[] args){
        int ch;
        String type;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the type of account (Saving/Current):");
        type = scan.nextLine();
        boolean status;
        SavingAccount s1 = new SavingAccount();
        CurrentAccount c1 = new CurrentAccount();
        
        while (true) {
            System.out.println("Enter your choice: \n 1. Create Account \n 2. Withdraw \n 3. Deposit \n 4. Calculate Interest \n 5. Generate Cheque \n 6. Deposit Cheque \n 7. Show Balance \n 8. Exit");
            ch = scan.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the name:");
                    String name = scan.next();
                    System.out.println("Enter the account number:");
                    int accno = scan.nextInt();
                    if(type.equalsIgnoreCase("saving")){
                        s1 = new SavingAccount(name, accno);
                    } else {
                        c1 = new CurrentAccount(name, accno);
                    }
                    System.out.println("Account created successfully");
                    break;
                    
                case 2:
                    System.out.println("Enter the amount to withdraw:");
                    double amount = scan.nextDouble();
                    if(type.equalsIgnoreCase("saving")) {
                        status = s1.withdraw(amount);
                    } else {
                        status = c1.withdraw(amount);
                    }
                    System.out.println(status ? "Withdraw completed successfully" : "Withdraw unsuccessful");
                    break;
                    
                case 3:
                    if(type.equalsIgnoreCase("saving")) {
                        s1.deposit();
                    } else {
                        c1.deposit();
                    }
                    break;
                    
                case 4:
                    if(type.equalsIgnoreCase("saving")) {
                        s1.calcInterest();
                    } else {
                        System.out.println("Service not available");
                    }
                    break;
                    
                case 5:
                    if(type.equalsIgnoreCase("current")) {
                        System.out.println("Enter the amount to generate cheque:");
                        System.out.println(c1.generateCheque(scan.nextDouble()));
                    } else {
                        System.out.println("Service not available");
                    }
                    break;
                    
                case 6:
                    if(type.equalsIgnoreCase("current")) {
                        c1.depositCheque();
                    } else {
                        System.out.println("Service not available");
                    }
                    break;
                    
                case 7:
                    if(type.equalsIgnoreCase("saving")) {
                        System.out.println(s1);
                    } else {
                        System.out.println(c1);
                    }
                    break;
                    
                case 8:
                    System.out.println("Exiting the program.");
                    scan.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Account {
    String name;
    String type;
    int accno;
    double balance;
    
    Account() {}
    
    Account(String name, int accno) {
        this.name = name;
        this.accno = accno;
        this.balance = 0;
    }
    
    void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount to deposit:");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }
    
    boolean withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
    
    public String toString() {
        return "Account [name=" + name + ", type=" + type + ", accno=" + accno + ", balance=" + balance + "]";
    }
}

class CurrentAccount extends Account {
    CurrentAccount() {}
    
    CurrentAccount(String name, int accno) {
        super(name, accno);
        type = "Current";
    }
    
    String generateCheque(double amount) {
        return "Cheque generated for Account: " + accno + ", Name: " + name + ", Amount: " + amount;
    }
    
    void depositCheque() {
        super.deposit();
        System.out.println("Cheque deposited successfully");
    }
    
    boolean withdraw(double amount) {
        if(super.withdraw(amount)) {
            if(balance < 2000) {
                System.out.println("100 rupees penalty for low balance");
            }
            return true;
        }
        return false;
    }
}

class SavingAccount extends Account {
    SavingAccount() {}
    
    SavingAccount(String name, int accno) {
        super(name, accno);
        type = "Saving";
    }
    
    void calcInterest() {
        double interest = balance * 0.05;
        System.out.println("Interest: " + interest + " has been deposited in your account");
        balance += interest;
    }
}
