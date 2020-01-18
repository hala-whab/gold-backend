package me.gold.model;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints=
                {@UniqueConstraint(columnNames = "date")}

)
public class Expensives {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String type;
    private String amount;
    private String date;
    private String employee_in_charge;
    private String to_whom;

    public Expensives() {
    }

    public Expensives(int id, String type, String amount, String date, String employee_in_charge, String to_whom) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.employee_in_charge = employee_in_charge;
        this.to_whom = to_whom;
    }

    public Expensives(String type, String amount, String date, String employee_in_charge, String to_whom) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.employee_in_charge = employee_in_charge;
        this.to_whom = to_whom;
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

    public String getTo_whom() {
        return to_whom;
    }

    public void setTo_whom(String to_whom) {
        this.to_whom = to_whom;
    }
}
