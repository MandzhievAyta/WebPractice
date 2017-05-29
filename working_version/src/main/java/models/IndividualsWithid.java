package models;

import javax.persistence.*;

/**
 * Created by ayta on 27.03.17.
 */
public class IndividualsWithid {
    private Integer id;
    private String firstName;
    private String secondName;
    private Integer clientId;

    public IndividualsWithid() {}
    public IndividualsWithid(Individuals p) {
        id = p.getId();
        firstName = p.getFirstName();
        secondName = p.getSecondName();
        clientId = p.getClient().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}

