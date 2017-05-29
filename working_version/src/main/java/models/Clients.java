package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ayta on 27.03.17.
 */
@Entity
@Table(name = "Clients")
public class Clients {
    private Integer id;
    private ClientType type;
    private Collection<Accounts> accounts;
    private Collection<Contacts> contacts;
    private Collection<Individuals> individuals;
    private Collection<Organizations> organizations;

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
    @Column(name = "type", nullable = false)
    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        if (id != null ? !id.equals(clients.id) : clients.id != null) {
            return false;
        } else if (type != null ? !type.equals(clients.type) : clients.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "client")
    public Collection<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Accounts> accounts) {
        this.accounts = accounts;
    }

    @OneToMany(mappedBy = "client")
    public Collection<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(Collection<Contacts> contacts) {
        this.contacts = contacts;
    }

    @OneToMany(mappedBy = "client")
    public Collection<Individuals> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(Collection<Individuals> individuals) {
        this.individuals = individuals;
    }

    @OneToMany(mappedBy = "client")
    public Collection<Organizations> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Collection<Organizations> organizations) {
        this.organizations = organizations;
    }

    public enum ClientType { individual, organization }
}
