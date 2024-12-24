# Payment System Program

Description

The Payment System is a simple Java-based console application that simulates a digital wallet for making payments to specific services, checking the wallet balance, and adding funds. The program uses a file named balance.txt to store the wallet's current balance, ensuring that the balance persists between program executions.

Features

1. Canteen Payment
Users can make payments for canteen services by scanning a QR code (simulated by selecting an option and entering an amount).

2. Stationery Payment
Users can make payments for stationery services using the same method as above.

3. Check Balance
Displays the current wallet balance to the user.

4. Add Money
Allows users to add funds to their wallet, which is updated and saved persistently.

5. Exit
Exits the application.


How It Works

1. Persistent Balance
The program reads the current balance from a file named balance.txt at startup.
If the file doesn't exist or contains invalid data, a default balance of 500.0 is initialized.

2. Payment System
When a payment is made, the balance is deducted by the payment amount if sufficient funds are available.
The updated balance is saved back to the file.

3. Adding Funds
Users can add funds to the wallet.
The new balance is saved to the file.

4. Error Handling
Handles missing or corrupted balance.txt gracefully by resetting to the default balance.
Ensures the application remains user-friendly with appropriate prompts and feedback.


File Requirements

The application requires a balance.txt file in the same directory as the program.
If the file is missing or corrupted, the program will recreate it with a default balance.


Notes

1. Ensure proper permissions for creating and writing to the balance.txt file in the directory.
2. If the file is manually edited or corrupted, the program will reset to the default balance upon the next run.


Future Enhancements

Adding support for additional services.
Improving user interface with a graphical UI.
Encrypting the balance file for added security.



   










