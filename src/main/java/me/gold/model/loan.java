package me.gold.model;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints=
                {@UniqueConstraint(columnNames = "loan_date")}

)
public class loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String loaner_id;
    private String loaner_name;
    private String loaner_type;
    private String loan_amount;
    private String paid;
    private String remaning;
    private String next_payment_amount;
    private String next_payment_date;
    private String loan_date;
    private String employee_in_charge;

    public loan() {
    }

    public loan(String loaner_id, String loaner_name, String loaner_type, String loan_amount, String paid, String remaning, String next_payment_amount, String next_payment_date, String loan_date,String employee_in_charge) {
        this.loaner_id = loaner_id;
        this.loaner_name = loaner_name;
        this.loaner_type = loaner_type;
        this.loan_amount = loan_amount;
        this.employee_in_charge=employee_in_charge;
        this.paid = paid;
        this.remaning = remaning;
        this.next_payment_amount = next_payment_amount;
        this.next_payment_date = next_payment_date;
        this.loan_date = loan_date;
    }

    public loan(int id, String loaner_id, String loaner_name, String loaner_type, String loan_amount, String paid, String remaning, String next_payment_amount, String next_payment_date, String loan_date,String employee_in_charge) {
        this.id = id;
        this.loaner_id = loaner_id;
        this.employee_in_charge=employee_in_charge;
        this.loaner_name = loaner_name;
        this.loaner_type = loaner_type;
        this.loan_amount = loan_amount;
        this.paid = paid;
        this.remaning = remaning;
        this.next_payment_amount = next_payment_amount;
        this.next_payment_date = next_payment_date;
        this.loan_date = loan_date;
    }

    public String getLoaner_id() {
        return loaner_id;
    }

    public String getLoaner_name() {
        return loaner_name;
    }

    public String getLoaner_type() {
        return loaner_type;
    }

    public String getLoan_amount() {
        return loan_amount;
    }

    public String getPaid() {
        return paid;
    }

    public String getRemaning() {
        return remaning;
    }

    public String getNext_payment_amount() {
        return next_payment_amount;
    }

    public String getNext_payment_date() {
        return next_payment_date;
    }

    public String getLoan_date() {
        return loan_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLoaner_id(String loaner_id) {
        this.loaner_id = loaner_id;
    }

    public void setLoaner_name(String loaner_name) {
        this.loaner_name = loaner_name;
    }

    public void setLoaner_type(String loaner_type) {
        this.loaner_type = loaner_type;
    }

    public void setLoan_amount(String loan_amount) {
        this.loan_amount = loan_amount;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public void setRemaning(String remaning) {
        this.remaning = remaning;
    }

    public void setNext_payment_amount(String next_payment_amount) {
        this.next_payment_amount = next_payment_amount;
    }

    public void setNext_payment_date(String next_payment_date) {
        this.next_payment_date = next_payment_date;
    }

    public void setLoan_date(String loan_date) {
        this.loan_date = loan_date;
    }

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }

}