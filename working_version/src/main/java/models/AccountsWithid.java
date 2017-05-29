package models;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by ayta on 27.03.17.
 */
public class AccountsWithid {
    private Integer id;
    private Integer balance;
    private Integer maxDebt;
    private Date payDebtDate;
    private Time payDebtTime;
    private String phoneNumber;
    private Integer clientId;

    public AccountsWithid() {}
    public AccountsWithid(Accounts p) {
        this.id = p.getId();
        this.balance = p.getBalance();
        this.maxDebt = p.getMaxDebt();
        this.payDebtDate = p.getPayDebtDate();
        this.payDebtTime = p.getPayDebtTime();
        this.phoneNumber = p.getPhoneNumber();
        this.clientId = p.getClient().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getMaxDebt() {
        return maxDebt;
    }

    public void setMaxDebt(Integer maxDebt) {
        this.maxDebt = maxDebt;
    }

    public Date getPayDebtDate() {
        return payDebtDate;
    }

    public void setPayDebtDate(Date payDebtDate) {
        this.payDebtDate = payDebtDate;
    }

    public Time getPayDebtTime() {
        return payDebtTime;
    }

    public void setPayDebtTime(Time payDebtTime) {
        this.payDebtTime = payDebtTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}