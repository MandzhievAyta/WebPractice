package models;

import javax.persistence.*;

/**
 * Created by ayta on 27.03.17.
 */
public class NumberGroupsWithid {
    private Integer id;
    private Integer groupNumber;
    private Integer accountId;

    public NumberGroupsWithid() {}
    public NumberGroupsWithid(NumberGroups p) {
        id = p.getId();
        groupNumber = p.getGroupNumber();
        accountId = p.getAccount().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}

