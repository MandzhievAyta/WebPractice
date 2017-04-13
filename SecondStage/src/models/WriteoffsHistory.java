package models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by ayta on 27.03.17.
 */
@Entity
@Table(name = "WriteoffsHistory")
public class WriteoffsHistory {
    private Integer id;
    private Date date;
    private Time time;
    private Integer value;
    private ContractsHistory contractsHistoryByContractId;
    private Accounts accountsByAccountId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Basic
    @Column(name = "value", nullable = false)
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WriteoffsHistory that = (WriteoffsHistory) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id", nullable = false)
    public ContractsHistory getContractsHistoryByContractId() {
        return contractsHistoryByContractId;
    }

    public void setContractsHistoryByContractId(ContractsHistory contractsHistoryByContractId) {
        this.contractsHistoryByContractId = contractsHistoryByContractId;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    public Accounts getAccountsByAccountId() {
        return accountsByAccountId;
    }

    public void setAccountsByAccountId(Accounts accountsByAccountId) {
        this.accountsByAccountId = accountsByAccountId;
    }

    @Override
    public String toString() {
        return "" + id + " " + date + " " + time + " " + value + " ContractId:" +
                contractsHistoryByContractId.getId() + " AccountId" + accountsByAccountId.getId();
    }
}

