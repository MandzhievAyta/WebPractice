package models;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.*;

/**
 * Created by ayta on 27.03.17.
 */
public class OrganizationsWithid {
    private Integer id;
    private String name;
    private Integer clientId;

    public OrganizationsWithid() {}
    public OrganizationsWithid(Organizations p) {
        id = p.getId();
        name = p.getName();
        clientId = p.getClient().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
