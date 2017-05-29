package models;

import DAO.Impl.ClientsDAO;

import javax.persistence.*;

/**
 * Created by ayta on 27.03.17.
 */
@Entity
@Table(name = "Organizations")
public class Organizations {
    private Integer id;
    private String name;
    private Clients client;

    public Organizations() {}
    public Organizations(OrganizationsWithid p) {
        id = p.getId();
        name = p.getName();
        ClientsDAO a = new ClientsDAO();
        client = a.getById(p.getClientId());
    }
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
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organizations that = (Organizations) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
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
}
