import controller.AccountController;
import controller.TransactionController;

import java.sql.SQLException;
import java.util.Scanner;

public class UIMenu {
    public static void showMenu() {
        System.out.println("------------------------------------");
        System.out.println("Choose on Option:");
        System.out.println("1- Add new Account");
        System.out.println("2- Deposit Amount");
        System.out.println("3- Withdraw Amount");
        System.out.println("4- Transfer Amount Between Accounts");
        System.out.println("5- Delete Account");
        System.out.println("6- Exit");
        System.out.println("------------------------------------");

    }

    public static void addNewAccount(Scanner scanner) throws SQLException {
        System.out.println("Enter the customer id");
        int customerId = scanner.nextInt();
        System.out.println("Enter the balance: ");
        int balance = scanner.nextInt();
        AccountController.createNewAccount(customerId, balance);
    }

    public static void deposit(Scanner scanner) throws SQLException {
        System.out.println("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter the amount: ");
        int amount = scanner.nextInt();
        TransactionController.deposit(amount, accountNumber);
    }

    public static void withdraw(Scanner scanner) throws SQLException {
        System.out.println("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter the amount: ");
        int amount = scanner.nextInt();
        TransactionController.withdraw(amount, accountNumber);
    }

    public static void transfer(Scanner scanner) throws SQLException {
        System.out.println("Enter your source account number: ");
        String sourceAccountNumber = scanner.nextLine();
        System.out.println("Enter your destination account number: ");
        String destinationAccountNumber = scanner.nextLine();
        System.out.println("Enter the amount: ");
        int amount = scanner.nextInt();
        TransactionController.transfer(amount, sourceAccountNumber, destinationAccountNumber);
    }

    public static void deleteAccount(Scanner scanner) throws SQLException {
        System.out.println("Enter your account number: ");
        scanner.nextLine();
        String accountNumber = scanner.nextLine();
        AccountController.deleteAccount(accountNumber);
    }

}
