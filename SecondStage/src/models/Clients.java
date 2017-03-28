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
    private Collection<Accounts> accountsById;
    private Collection<Contacts> contactsById;
    private Collection<Individuals> individualsById;
    private Collection<Organizations> organizationsById;

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

    @OneToMany(mappedBy = "clientsByClientId")
    public Collection<Accounts> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<Accounts> accountsById) {
        this.accountsById = accountsById;
    }

    @OneToMany(mappedBy = "clientsByClientId")
    public Collection<Contacts> getContactsById() {
        return contactsById;
    }

    public void setContactsById(Collection<Contacts> contactsById) {
        this.contactsById = contactsById;
    }

    @OneToMany(mappedBy = "clientsByClientId")
    public Collection<Individuals> getIndividualsById() {
        return individualsById;
    }

    public void setIndividualsById(Collection<Individuals> individualsById) {
        this.individualsById = individualsById;
    }

    @OneToMany(mappedBy = "clientsByClientId")
    public Collection<Organizations> getOrganizationsById() {
        return organizationsById;
    }

    public void setOrganizationsById(Collection<Organizations> organizationsById) {
        this.organizationsById = organizationsById;
    }

    public enum ClientType {
        individual("individual"),
        organization("organization");

        private final String label;

        ClientType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

    }
}
