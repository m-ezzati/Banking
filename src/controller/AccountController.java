package controller;

import model.Account;
import service.AccountService;

import java.sql.SQLException;

public class AccountController {
    public static void createNewAccount(Integer customerId, Integer balance) throws SQLException {
        String nextAccountNumber = nextAccountNumber();
        Account account = new Account(0, customerId, nextAccountNumber, balance);
        AccountService.addAccount(account);
        System.out.println("New account added, the acount number is: " + nextAccountNumber);
    }


    public static String nextAccountNumber() throws SQLException {
        String maxAccountNumber = AccountService.fetchLastAccountNumber();
        return String.valueOf(Integer.parseInt(maxAccountNumber) + 1);
    }


    public static void deleteAccount(String accountNumber) throws SQLException {
        AccountService.deleteAccount(accountNumber);
    }
}
