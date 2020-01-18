package me.gold.model;

import javax.persistence.*;

//@Entity
//@Table(
//        uniqueConstraints=
//                {@UniqueConstraint(columnNames = "date")}
//
//)
public class supplierstransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String supplier_id;
    private String supplier_name;
    private String weight;
    private String grams_type;

    private String Remaning;
    private String manufactring_price;
    private String currency;
    private  String duedate;
    private String date;
    private String employee_in_charge;

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }

    public supplierstransactions(String supplier_id, String supplier_name, String weight, String grams_type, String remaning, String manufactring_price, String currency, String duedate, String date, String employee_in_charge) {
        this.supplier_id = supplier_id;
        this.employee_in_charge=employee_in_charge;
        this.supplier_name = supplier_name;
        this.weight = weight;
        this.grams_type = grams_type;
this.duedate=duedate;
        Remaning = remaning;
        this.manufactring_price = manufactring_price;
        this.currency = currency;
        this.date = date;
    }

    public supplierstransactions(int id, String supplier_id, String supplier_name, String weight, String grams_type, String remaning, String manufactring_price, String currency, String duedate, String date, String employee_in_charge) {
        this.id = id;
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.employee_in_charge=employee_in_charge;
        this.weight = weight;
        this.grams_type = grams_type;
        this.duedate=duedate;

        Remaning = remaning;
        this.manufactring_price = manufactring_price;
        this.currency = currency;
        this.date = date;
    }



    public String getRemaning() {
        return Remaning;
    }

    public void setRemaning(String remaning) {
        Remaning = remaning;
    }

    public String getCustomer_name() {
        return supplier_name;
    }

    public void setCustomer_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public supplierstransactions() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_id() {
        return supplier_id;
    }

    public void setCustomer_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getDept_grams() {
        return grams_type;
    }

    public void setDept_grams(String grams_type) {
        this.grams_type = grams_type;
    }

    public String getGram_cash_price() {
        return manufactring_price;
    }

    public void setGram_cash_price(String manufactring_price) {
        this.manufactring_price = manufactring_price;
    }

    public String getGram_card_price() {
        return currency;
    }

    public void setGram_card_price(String currency) {
        this.currency = currency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}