package me.gold.model;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints=
                {@UniqueConstraint(columnNames = "date")}

)
public class debtpurchasedetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dept_id;
    private String no_of_grams;
    private String cash_paid;
    private String card_paid;
    private String date;
    private String duedate;
    private String employee_in_charge;

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public debtpurchasedetails(int id, String dept_id, String no_of_grams, String cash_paid, String card_paid, String date, String duedate, String employee_in_charge) {
        this.id = id;
        this.dept_id = dept_id;
        this.no_of_grams = no_of_grams;
        this.cash_paid = cash_paid;
        this.card_paid = card_paid;
        this.date = date;
        this.employee_in_charge=employee_in_charge;
        this.duedate=duedate;
    }

    public debtpurchasedetails() {
    }

    public debtpurchasedetails(String dept_id, String no_of_grams, String cash_paid, String card_paid, String date, String duedate, String employee_in_charge) {
        this.dept_id = dept_id;
        this.no_of_grams = no_of_grams;
        this.employee_in_charge=employee_in_charge;
        this.cash_paid = cash_paid;
        this.card_paid = card_paid;
        this.date = date;
        this.duedate=duedate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getNo_of_grams() {
        return no_of_grams;
    }

    public void setNo_of_grams(String no_of_grams) {
        this.no_of_grams = no_of_grams;
    }

    public String getCash_paid() {
        return cash_paid;
    }

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }

    public void setCash_paid(String cash_paid) {
        this.cash_paid = cash_paid;
    }

    public String getCard_paid() {
        return card_paid;
    }

    public void setCard_paid(String card_paid) {
        this.card_paid = card_paid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}