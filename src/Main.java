import controller.AccountController;
import controller.TransactionController;
import model.Account;
import service.AccountService;
import service.TransactionService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    TransactionController transactionController;
    public static void main(String[] args) throws SQLException {
        boolean showMenu = true;
        Scanner scanner = new Scanner(System.in);
        while (showMenu){
            UIMenu.showMenu();
            int option = scanner.nextInt();
            switch (option){
                case 1 -> UIMenu.addNewAccount(scanner);
                case 2 -> UIMenu.deposit(scanner);
                case 3 -> UIMenu.withdraw(scanner);
                case 4 -> UIMenu.transfer(scanner);
                case 5 -> UIMenu.deleteAccount(scanner);
                case 6 -> showMenu = false;
            }
        }

    }
}
