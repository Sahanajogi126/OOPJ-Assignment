import java.io.*;
import java.util.Scanner;

public class PaymentSystem {
    private static final String BALANCE_FILE = "balance.txt";
    private static double balance;

    // Load the balance from the file
    public static void loadBalance() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BALANCE_FILE))) {
            balance = Double.parseDouble(reader.readLine());
        } catch (FileNotFoundException e) {
            System.out.println("Balance file not found. Initializing with default balance: 500.0");
            balance = 500.0;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading balance. Initializing with default balance: 500.0");
            balance = 500.0;
        }
    }

    // Save the balance to the file
    public static void saveBalance() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BALANCE_FILE))) {
            writer.write(String.valueOf(balance));
        } catch (IOException e) {
            System.out.println("Error saving balance to file.");
        }
    }

    // Make a payment
    public static void makePayment(String service, double amount) {
        if (amount <= balance) {
            balance -= amount;
            saveBalance(); // Save updated balance to file
            System.out.printf("Payment successful for %s! Current balance: %.2f%n", service, balance);
        } else {
            System.out.println("Insufficient balance. Please add money to your wallet.");
        }
    }

    // Add money to the wallet
    public static void addMoney(double amount) {
        balance += amount;
        saveBalance(); // Save updated balance to file
        System.out.printf("Amount added successfully! Current balance: %.2f%n", balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadBalance(); // Load balance when the program starts

        int choice;
        double amount;

        do {
            System.out.println("\n1. Canteen Payment");
            System.out.println("2. Stationery Payment");
            System.out.println("3. Check Balance");
            System.out.println("4. Add Money");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount for canteen: ");
                    amount = scanner.nextDouble();
                    makePayment("Canteen", amount);
                    break;
                case 2:
                    System.out.print("Enter amount for stationery: ");
                    amount = scanner.nextDouble();
                    makePayment("Stationery", amount);
                    break;
                case 3:
                    System.out.printf("Current balance: %.2f%n", balance);
                    break;
                case 4:
                    System.out.print("Enter amount to add: ");
                    amount = scanner.nextDouble();
                    addMoney(amount);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
}
}
