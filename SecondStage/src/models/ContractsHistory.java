package models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by ayta on 27.03.17.
 */
@Entity
@Table(name = "ContractsHistory")
public class ContractsHistory {
    private Integer id;
    private Relevance relevance;
    private TariffType tariffType;
    private Date date;
    private Time time;
    private Accounts account;
    private CallTariffs callTariff;
    private SmsTariffs smsTariff;
    private InternetTariffs internetTariff;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "relevance", nullable = false)
    public Relevance getRelevance() {
        return relevance;
    }

    public void setRelevance(Relevance relevance) {
        this.relevance = relevance;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tariff_type", nullable = false)
    public TariffType getTariffType() {
        return tariffType;
    }

    public void setTariffType(TariffType tariffType) {
        this.tariffType = tariffType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractsHistory that = (ContractsHistory) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (relevance != null ? !relevance.equals(that.relevance) : that.relevance != null) return false;
        if (tariffType != null ? !tariffType.equals(that.tariffType) : that.tariffType != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (time != null ? !time.toString().equals(that.time.toString()) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (relevance != null ? relevance.hashCode() : 0);
        result = 31 * result + (tariffType != null ? tariffType.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    @ManyToOne
    @JoinColumn(name = "calltariff_id", referencedColumnName = "id")
    public CallTariffs getCallTariff() {
        return callTariff;
    }

    public void setCallTariff(CallTariffs callTariffs) {
        this.callTariff = callTariffs;
    }

    @ManyToOne
    @JoinColumn(name = "smstariff_id", referencedColumnName = "id")
    public SmsTariffs getSmsTariff() {
        return smsTariff;
    }

    public void setSmsTariff(SmsTariffs smsTariffs) {
        this.smsTariff = smsTariffs;
    }

    @ManyToOne
    @JoinColumn(name = "internettariff_id", referencedColumnName = "id")
    public InternetTariffs getInternetTariff() {
        return internetTariff;
    }

    public void setInternetTariff(InternetTariffs internetTariffsByInternettariffId) {
        this.internetTariff = internetTariffsByInternettariffId;
    }

    @OneToMany(mappedBy = "contractsHistory")
    public Collection<WriteoffsHistory> getWriteoffsHistories() {
        return writeoffsHistories;
    }

    public void setWriteoffsHistories(Collection<WriteoffsHistory> writeoffsHistories) {
        this.writeoffsHistories = writeoffsHistories;
    }
    public enum Relevance { active, ended }
    public enum TariffType { call, sms, internet }

    @Override
    public String toString() {
        return "" + relevance + " " + tariffType + " " + date + " " + time + " " + account.getId();
    }
}
