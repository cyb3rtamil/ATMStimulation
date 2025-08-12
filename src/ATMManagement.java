import java.util.Scanner;
public class ATMManagement {
    private static double balance = 1000.00;
    private static String pin = "1234";
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        if (!authenticateUser()) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }
        int choice;
        do {
            System.out.println("\n=== Welcome to the ATM Management System ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    changePIN();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
    private static boolean authenticateUser() {
        System.out.print("Please enter your PIN to login: ");
        String inputPIN = scanner.next();
        return inputPIN.equals(pin);
    }
    private static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }
    private static void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance -= amount;
            System.out.printf("Please collect your cash: $%.2f%n", amount);
            checkBalance();
        }
    }
    private static void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            System.out.printf("Successfully deposited: $%.2f%n", amount);
            checkBalance();
        }
    }
    private static void changePIN() {
        System.out.print("Enter current PIN: ");
        String currentPIN = scanner.next();

        if (!currentPIN.equals(pin)) {
            System.out.println("Incorrect PIN. Cannot change PIN.");
            return;
        }
        System.out.print("Enter new PIN: ");
        String newPIN = scanner.next();

        if (newPIN.length() != 4 || !newPIN.matches("\\d{4}")) {
            System.out.println("PIN must be exactly 4 digits.");
            return;
        }
        pin = newPIN;
        System.out.println("PIN successfully changed.");
    }
}