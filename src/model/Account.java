package model;

public class Account {
    private Integer id;
    private Integer customerId;
    private String accountNumber;
    private Integer balance;

    public Account(Integer id, Integer customerId, String accountNumber, Integer balance) {
        this.id = id;
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Integer getBalance() {
        return balance;
    }
}
