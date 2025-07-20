package service;

import model.Customer;
import util.DBConnection;

import java.sql.*;

public class CustomerService {

    public void addCustomer(Customer customer) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "insert into customer (name, email, phone) VALUES (? ? ? )";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, customer.getName());
        stmt.setString(2, customer.getEmail());
        stmt.setString(3, customer.getPhone());
        stmt.executeUpdate();
        System.out.println("New customer added");
    }

    public void updateCustomer(Integer id, Customer newCustomer) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "update customer\n" +
                "set name = ? , email = ?, phone = ? \n" +
                "where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, newCustomer.getName());
        stmt.setString(2, newCustomer.getEmail());
        stmt.setString(3, newCustomer.getPhone());
        stmt.setInt(4, newCustomer.getId());
        stmt.executeUpdate();
        System.out.println("The customer updated");
    }

    public Customer fetchCustomer(Integer id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "select from customer where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        if(result.next()){
            Integer customerId = result.getInt("id");
            String name = result.getString("name");
            String email = result.getString("email");
            String phone = result.getString("phone");
            return new Customer(customerId, name, email, phone);
        }else {
            System.out.println("The customer not found");
            return null;
        }
    }


}
