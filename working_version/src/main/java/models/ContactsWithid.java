package models;


/**
 * Created by ayta on 27.03.17.
 */
public class ContactsWithid {
    private Integer id;
    private String firstName;
    private String secondName;
    private String address;
    private String phoneNumber;
    private String mail;
    private Integer clientId;
    public ContactsWithid() {}
    public ContactsWithid(Contacts p) {
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.secondName = p.getSecondName();
        this.address = p.getAddress();
        this.phoneNumber = p.getPhoneNumber();
        this.mail = p.getMail();
        this.clientId = p.getClient().getId();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}

