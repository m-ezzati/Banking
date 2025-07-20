package model;

import java.time.LocalDateTime;
import java.sql.Date;

public class Transaction {
    private Integer id;
    private Integer accountId;
    private String type; //deposit-withdraw-transfer
    private Integer amount;
    private Date date;
    private String details;

    public Transaction(Integer id, Integer accountId, String type, Integer amount, Date date, String details) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.details = details;
    }


    public Integer getId() {
        return id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }
}
