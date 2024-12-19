import java.util.Scanner; 
 
public class PaymentSystem { 
    private static double balance = 500.0; 
 
    public static void makePayment(String service, double amount) { 
        if (amount <= balance) { 
            balance -= amount; 
            System.out.printf("Payment successful for %s! Current balance: %.2f%n", service, 
balance); 
        } else { 
            System.out.println("Insufficient balance. Please add money to your wallet."); 
        } 
    } 
 
    public static void addMoney(double amount) { 
        balance += amount; 
        System.out.printf("Amount added successfully! Current balance: %.2f%n", balance); 
    } 
 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        int choice; 
        double amount; 
 
        do { 
            System.out.println("\n1. Scan QR Code for Canteen Payment"); 
            System.out.println("2. Scan QR Code for Stationery Payment"); 
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
