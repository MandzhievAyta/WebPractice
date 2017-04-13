package models;

import javax.persistence.*;

/**
 * Created by ayta on 27.03.17.
 */
@Entity
@Table(name = "Contacts")
public class Contacts {
    private Integer id;
    private String firstName;
    private String secondName;
    private String address;
    private String phoneNumber;
    private String mail;
    private Clients clientsByClientId;

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
    @Column(name = "first_name", nullable = false, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name", nullable = false, length = 100)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, length = 100)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "mail", nullable = true, length = 100)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacts contacts = (Contacts) o;

        if (id != null ? !id.equals(contacts.id) : contacts.id != null) return false;
        if (firstName != null ? !firstName.equals(contacts.firstName) : contacts.firstName != null) return false;
        if (secondName != null ? !secondName.equals(contacts.secondName) : contacts.secondName != null) return false;
        if (address != null ? !address.equals(contacts.address) : contacts.address != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(contacts.phoneNumber) : contacts.phoneNumber != null)
            return false;
        if (mail != null ? !mail.equals(contacts.mail) : contacts.mail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Clients getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(Clients clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    @Override
    public String toString() {
        return "" + firstName + " " + secondName + " " + address + " " + phoneNumber + " " + mail + " ";
    }
}

