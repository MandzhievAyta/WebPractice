package models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by ayta on 27.03.17.
 */
public class ReplenishHistoryWithid {
    private Integer id;
    private Date date;
    private Time time;
    private Integer amount;
    private Integer accountId;

    public ReplenishHistoryWithid() {}
    public ReplenishHistoryWithid(ReplenishHistory p) {
        id = p.getId();
        date = p.getDate();
        time = p.getTime();
        amount = p.getAmount();
        accountId = p.getAccount().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}

