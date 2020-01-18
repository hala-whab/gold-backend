package me.gold.model;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints=
                {@UniqueConstraint(columnNames = "date")}

)
public class DsellHD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  type;
    private String amount;
    private String payment;
    private String cashprice;
    private String cardprice;
    private  String date;
    private String employee_in_charge;

    public DsellHD() {
    }

    public DsellHD(int id, String type, String amount, String payment, String cashprice, String cardprice, String date, String employee_in_charge) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.payment = payment;
        this.cashprice = cashprice;
        this.cardprice = cardprice;
        this.date = date;
        this.employee_in_charge = employee_in_charge;
    }

    public DsellHD(String type, String amount, String payment, String cashprice, String cardprice, String date, String employee_in_charge) {
        this.type = type;
        this.amount = amount;
        this.payment = payment;
        this.cashprice = cashprice;
        this.cardprice = cardprice;
        this.date = date;
        this.employee_in_charge = employee_in_charge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCashprice() {
        return cashprice;
    }

    public void setCashprice(String cashprice) {
        this.cashprice = cashprice;
    }

    public String getCardprice() {
        return cardprice;
    }

    public void setCardprice(String cardprice) {
        this.cardprice = cardprice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }
}
