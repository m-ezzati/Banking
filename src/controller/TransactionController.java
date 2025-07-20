package controller;

import model.Account;
import model.Transaction;
import service.AccountService;
import service.TransactionService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.Objects;

public class TransactionController {

    public static void deposit(Integer amount, String accountNumber) throws SQLException {
        Account account = AccountService.fetchAccount(accountNumber);
        Integer newBalance = Objects.requireNonNull(account).getBalance() + amount;
        Transaction transaction = new Transaction(0, account.getId(), "deposit", amount, new Date(System.currentTimeMillis()), "deposit to account");
        TransactionService.addTransaction(transaction);
        AccountService.updateAccountBalance(account.getId(), newBalance);
    }

    public static void withdraw(Integer amount, String accountNumber) throws SQLException {
        Account account = AccountService.fetchAccount(accountNumber);
        Integer newBalance = Objects.requireNonNull(account).getBalance() - amount;
        if (newBalance > 0) {
            Transaction transaction = new Transaction(0, account.getId(), "withdraw", amount, new Date(System.currentTimeMillis()), "withdraw from account");
            TransactionService.addTransaction(transaction);
            AccountService.updateAccountBalance(account.getId(), newBalance);
        } else {
            System.out.println("Insufficient balance");
        }

    }

    public static void transfer(Integer amount, String sourceAccountNumber, String destinationAccountNumber) throws SQLException {
        Account sourceAccount = AccountService.fetchAccount(sourceAccountNumber);
        Account destinationAccount = AccountService.fetchAccount(destinationAccountNumber);
        Integer newSourceBalance = Objects.requireNonNull(sourceAccount).getBalance() - amount;
        if (newSourceBalance > 0) {
            Integer newDestinationBalance = Objects.requireNonNull(destinationAccount).getBalance() + amount;
            Transaction transactionDebtor = new Transaction(0, sourceAccount.getId(), "transfer", amount, new Date(System.currentTimeMillis()), "transfer - debtor account");
            Transaction transactionCreditor = new Transaction(0, destinationAccount.getId(), "transfer", amount, new Date(System.currentTimeMillis()), "transfer - creditor account");
            TransactionService.addTransaction(transactionDebtor);
            TransactionService.addTransaction(transactionCreditor);
            AccountService.updateAccountBalance(destinationAccount.getId(), newDestinationBalance);
            AccountService.updateAccountBalance(sourceAccount.getId(), newSourceBalance);
        } else {
            System.out.println("Insufficient balance");
        }


    }
}
