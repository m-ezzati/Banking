package service;

import model.Transaction;
import util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionService {
    public static void addTransaction(Transaction transaction) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "insert into transaction (account_id, type, amount, date, detail) values (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, transaction.getId());
        stmt.setString(2, transaction.getType());
        stmt.setInt(3, transaction.getAmount());
        stmt.setDate(4, (Date) transaction.getDate());
        stmt.setString(5, transaction.getDetails());
        stmt.executeUpdate();
        System.out.println("New transaction added");
    }



}
