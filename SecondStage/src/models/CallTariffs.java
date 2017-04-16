package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ayta on 27.03.17.
 */
@Entity
@Table(name = "CallTariffs")
public class CallTariffs {
    private Integer id;
    private Integer price;
    private String name;
    private Integer group_price;
    private Collection<ContractsHistory> contractsHistories;

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
    @Column(name = "price", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        return group_price;
    }

    public void setGroupPrice(Integer group_price) {
        this.group_price = group_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallTariffs that = (CallTariffs) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (group_price != null ? !group_price.equals(that.group_price) : that.group_price != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (group_price != null ? group_price.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "callTariff")
    public Collection<ContractsHistory> getContractsHistories() {
        return contractsHistories;
    }

    public void setContractsHistories(Collection<ContractsHistory> contractsHistories) {
        this.contractsHistories = contractsHistories;
    }
}
