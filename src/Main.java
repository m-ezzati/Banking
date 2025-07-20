import controller.AccountController;
import controller.TransactionController;
import model.Account;
import service.AccountService;
import service.TransactionService;

import java.sql.SQLException;

public class Main {
    TransactionController transactionController;
    public static void main(String[] args) throws SQLException {
        Account account = new Account(0,1,"1236",1000);
        AccountService.addAccount(account);
//        TransactionController.deposit(1200,"1234");
//        TransactionController.withdraw(800,"1234");
//        TransactionController.transfer(1000,"1234","1235");
    }
    public void showMenu(){
        System.out.println("Choose on Option:");
        System.out.println("1- Add new Account");
        System.out.println("2- ");
    }
}
