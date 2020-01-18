package me.gold.model;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints=
                {@UniqueConstraint(columnNames = "date")}

)
public class debtpurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customer_id;
    private String customer_name;
    private String weight;
    private String dept_grams;

    private String Remaning;
    private String gram_cash_price;
    private String gram_card_price;
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

    public debtpurchase(String customer_id, String customer_name, String weight, String dept_grams, String remaning, String gram_cash_price, String gram_card_price, String duedate,String date, String employee_in_charge) {
        this.customer_id = customer_id;
        this.employee_in_charge=employee_in_charge;
        this.customer_name = customer_name;
        this.weight = weight;
        this.dept_grams = dept_grams;
this.duedate=duedate;
        Remaning = remaning;
        this.gram_cash_price = gram_cash_price;
        this.gram_card_price = gram_card_price;
        this.date = date;
    }

    public debtpurchase(int id, String customer_id, String customer_name, String weight, String dept_grams, String remaning, String gram_cash_price, String gram_card_price,String duedate, String date, String employee_in_charge) {
        this.id = id;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.employee_in_charge=employee_in_charge;
        this.weight = weight;
        this.dept_grams = dept_grams;
        this.duedate=duedate;

        Remaning = remaning;
        this.gram_cash_price = gram_cash_price;
        this.gram_card_price = gram_card_price;
        this.date = date;
    }



    public String getRemaning() {
        return Remaning;
    }

    public void setRemaning(String remaning) {
        Remaning = remaning;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public debtpurchase() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getDept_grams() {
        return dept_grams;
    }

    public void setDept_grams(String dept_grams) {
        this.dept_grams = dept_grams;
    }

    public String getGram_cash_price() {
        return gram_cash_price;
    }

    public void setGram_cash_price(String gram_cash_price) {
        this.gram_cash_price = gram_cash_price;
    }

    public String getGram_card_price() {
        return gram_card_price;
    }

    public void setGram_card_price(String gram_card_price) {
        this.gram_card_price = gram_card_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}