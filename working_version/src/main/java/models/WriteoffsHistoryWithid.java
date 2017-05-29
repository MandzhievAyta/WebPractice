package models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by ayta on 27.03.17.
 */
public class WriteoffsHistoryWithid {
    private Integer id;
    private Date date;
    private Time time;
    private Integer value;
    private Integer contractsHistoryId;
    private Integer accountId;

    public WriteoffsHistoryWithid() {}
    public WriteoffsHistoryWithid(WriteoffsHistory p) {
        id = p.getId();
        date = p.getDate();
        time = p.getTime();
        value = p.getValue();
        contractsHistoryId = p.getContractsHistory().getId();
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getContractsHistoryId() {
        return contractsHistoryId;
    }

    public void setContractsHistoryId(Integer contractsHistoryId) {
        this.contractsHistoryId = contractsHistoryId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}

