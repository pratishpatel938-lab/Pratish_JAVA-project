import java.util.*;

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Amount must be positive.");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance.");
        }
        balance -= amount;
    }
}

public class ATM1 {
    private static final int PIN = 1234;
    public static void main(String[] args) throws Exception { 
        Scanner sc = new Scanner(System.in);
        Account userAcc = new Account(50000.0);

        System.out.print("Enter PIN: ");
        if (sc.nextInt() != PIN) {
            System.out.println("Invalid PIN. System locked.");
        }

        while (true) {
            System.out.println("\n1. Withdraw | 2. Balance | 3. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 3) break;
            if (choice == 1) {
                System.out.print("Amount: ");
                userAcc.withdraw(sc.nextDouble()); 
                System.out.println("Success!");
            } else if (choice == 2) {
                System.out.println("Balance: " + userAcc.getBalance());
            }
        }
        System.out.println("Goodbye!");
        sc.close();
    }
}
