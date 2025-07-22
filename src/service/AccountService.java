package service;

import model.Account;
import model.Customer;
import util.DBConnection;

import java.sql.*;

public class AccountService {

    public static void addAccount(Account account) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "insert into account (customer_id, account_number, balance) values (?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, account.getCustomerId());
        stmt.setString(2, account.getAccountNumber());
        stmt.setInt(3, account.getBalance());
        stmt.executeUpdate();
    }

    public static void updateAccountBalance(Integer accountId, Integer newBalance) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "update account set balance = ? where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, newBalance);
        stmt.setInt(2, accountId);
        stmt.executeUpdate();
        System.out.println("The balance is up to date!");
    }

    public static void deleteAccount(String accountNumber) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "delete from account where account_number = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, accountNumber);
        int result = stmt.executeUpdate();
        if(result>0){
            System.out.println("Your account with account number "+ accountNumber + " deleted");
        }else {
            System.out.println("Account with this account number is not exists!");
        }

    }

    public static String fetchLastAccountNumber() throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "select Max(account_number) from account";
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        if (result.next()) {
            return result.getObject(1).toString();
        }
        return "12345";
    }

    public static Account fetchAccount(String accountNumber) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "select * from account where account_number = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, accountNumber);
        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            Integer accountId = (Integer) result.getObject("id");
            Integer customerId = (Integer) result.getObject("customer_id");
            Integer balance = (Integer) result.getObject("balance");
            return new Account(accountId, customerId, accountNumber, balance);
        } else {
            System.out.println("The Account not found");
            return null;
        }
    }

}


