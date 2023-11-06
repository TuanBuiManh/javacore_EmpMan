package vn.fapaptech.entity;

public class Customer {
    String ID;
    String NameCus;

    public Customer() {
    }

    public Customer(String ID, String nameCus) {
        this.ID = ID;
        NameCus = nameCus;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNameCus() {
        return NameCus;
    }

    public void setNameCus(String nameCus) {
        NameCus = nameCus;
    }
}
