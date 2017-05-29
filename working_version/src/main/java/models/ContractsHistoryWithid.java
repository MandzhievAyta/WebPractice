package models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by ayta on 27.03.17.
 */
public class ContractsHistoryWithid {
    private Integer id;
    private ContractsHistory.Relevance relevance;
    private ContractsHistory.TariffType tariffType;
    private Date date;
    private Time time;
    private Integer accountId;
    private Integer callTariffId;
    private Integer smsTariffId;
    private Integer internetTariffId;
    public ContractsHistoryWithid() {}
    public ContractsHistoryWithid(ContractsHistory p) {
        id = p.getId();
        relevance = p.getRelevance();
        tariffType = p.getTariffType();
        date = p.getDate();
        time = p.getTime();
        accountId = p.getAccount().getId();
        callTariffId = p.getCallTariff().getId();
        smsTariffId = p.getSmsTariff().getId();
        internetTariffId = p.getInternetTariff().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContractsHistory.Relevance getRelevance() {
        return relevance;
    }

    public void setRelevance(ContractsHistory.Relevance relevance) {
        this.relevance = relevance;
    }

    public ContractsHistory.TariffType getTariffType() {
        return tariffType;
    }

    public void setTariffType(ContractsHistory.TariffType tariffType) {
        this.tariffType = tariffType;
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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getCallTariffId() {
        return callTariffId;
    }

    public void setCallTariffId(Integer callTariffId) {
        this.callTariffId = callTariffId;
    }

    public Integer getSmsTariffId() {
        return smsTariffId;
    }

    public void setSmsTariffId(Integer smsTariffId) {
        this.smsTariffId = smsTariffId;
    }

    public Integer getInternetTariffId() {
        return internetTariffId;
    }

    public void setInternetTariffId(Integer internetTariffId) {
        this.internetTariffId = internetTariffId;
    }
}
