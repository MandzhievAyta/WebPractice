package models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by ayta on 27.03.17.
 */
@Entity
@Table(name = "Accounts")
public class Accounts {
    private Integer id;
    private Integer balance;
    private Integer maxDebt;
    private Date payDebtDate;
    private Time payDebtTime;
    private String phoneNumber;
    private Clients client;
    private Collection<ContractsHistory> contractsHistories;
    private Collection<NumberGroups> numberGroups;
    private Collection<ReplenishHistory> replenishHistories;
    private Collection<WriteoffsHistory> writeoffsHistories;

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
    @Column(name = "balance", nullable = false)
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "max_debt", nullable = false)
    public Integer getMaxDebt() {
        return maxDebt;
    }

    public void setMaxDebt(Integer maxDebt) {
        this.maxDebt = maxDebt;
    }

    @Basic
    @Column(name = "pay_debt_date", nullable = false)
    public Date getPayDebtDate() {
        return payDebtDate;
    }

    public void setPayDebtDate(Date payDebtDate) {
        this.payDebtDate = payDebtDate;
    }

    @Basic
    @Column(name = "pay_debt_time", nullable = false)
    public Time getPayDebtTime() {
        return payDebtTime;
    }

    public void setPayDebtTime(Time payDebtTime) {
        this.payDebtTime = payDebtTime;
    }

    @Basic
    @Column(name = "phone_number", nullable = false, length = 100)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accounts accounts = (Accounts) o;

        if (id != null ? !id.equals(accounts.id) : accounts.id != null) return false;
        //if (clientId != null ? !clientId.equals(accounts.clientId) : accounts.clientId != null) return false;
        if (balance != null ? !balance.equals(accounts.balance) : accounts.balance != null) return false;
        if (maxDebt != null ? !maxDebt.equals(accounts.maxDebt) : accounts.maxDebt != null) return false;
        if (payDebtDate != null ? !payDebtDate.equals(accounts.payDebtDate) : accounts.payDebtDate != null)
            return false;
        if (payDebtTime != null ? !payDebtTime.equals(accounts.payDebtTime) : accounts.payDebtTime != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(accounts.phoneNumber) : accounts.phoneNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (maxDebt != null ? maxDebt.hashCode() : 0);
        result = 31 * result + (payDebtDate != null ? payDebtDate.hashCode() : 0);
        result = 31 * result + (payDebtTime != null ? payDebtTime.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    @OneToMany(mappedBy = "account")
    public Collection<ContractsHistory> getContractsHistoriesById() {
        return contractsHistories;
    }

    public void setContractsHistoriesById(Collection<ContractsHistory> contractsHistoriesById) {
        this.contractsHistories = contractsHistoriesById;
    }

    @OneToMany(mappedBy = "account")
    public Collection<NumberGroups> getNumberGroupssById() {
        return numberGroups;
    }

    public void setNumberGroupssById(Collection<NumberGroups> numberGroupssById) {
        this.numberGroups = numberGroupssById;
    }

    @OneToMany(mappedBy = "account")
    public Collection<ReplenishHistory> getReplenishHistoriesById() {
        return replenishHistories;
    }

    public void setReplenishHistoriesById(Collection<ReplenishHistory> replenishHistoriesById) {
        this.replenishHistories = replenishHistoriesById;
    }

    @OneToMany(mappedBy = "account")
    public Collection<WriteoffsHistory> getWriteoffsHistoriesById() {
        return writeoffsHistories;
    }

    public void setWriteoffsHistoriesById(Collection<WriteoffsHistory> writeoffsHistoriesById) {
        this.writeoffsHistories = writeoffsHistoriesById;
    }
}

