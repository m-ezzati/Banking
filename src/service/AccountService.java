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
        System.out.println("New account added");
    }

    public static void updateAccountBalance(Integer accountId , Integer newBalance) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "update account set balance = ? where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, newBalance);
        stmt.setInt(2, accountId);
        stmt.executeUpdate();
        System.out.println("The balance is up to date!");
    }

    public void deleteAccount(){

    }

    public static Account fetchAccount(String accountNumber) throws SQLException {

        Connection connection = DBConnection.getConnection();
        String sql = "select * from account where account_number = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, accountNumber);
        ResultSet result = stmt.executeQuery();
        ResultSetMetaData metaData = result.getMetaData();
//        System.out.println("metaData.getColumnName"+ result.next());
        if(result.next()){
            System.out.println("if");
            Integer accountId = (Integer) result.getObject("id");
            Integer customerId = (Integer) result.getObject("customer_id");
            Integer balance = (Integer) result.getObject("balance");
            return new Account(accountId, customerId ,accountNumber, balance);
        }else {
            System.out.println("The Account not found");
            return null;
        }
    }

}


