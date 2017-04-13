package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ayta on 27.03.17.
 */
@Entity
@Table(name = "SmsTariffs")
public class SmsTariffs {
    private Integer id;
    private String name;
    private Integer price;
    private Integer group_price;
    private Collection<ContractsHistory> contractsHistoriesById;

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

    @Basic
    @Column(name = "group_price", nullable = false)
    public Integer getGroupPrice() {
        return price;
    }

    public void setGroupPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsTariffs that = (SmsTariffs) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "smsTariffsBySmstariffId")
    public Collection<ContractsHistory> getContractsHistoriesById() {
        return contractsHistoriesById;
    }

    public void setContractsHistoriesById(Collection<ContractsHistory> contractsHistoriesById) {
        this.contractsHistoriesById = contractsHistoriesById;
    }
}
