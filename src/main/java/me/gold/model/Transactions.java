package me.gold.model;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints=
                {@UniqueConstraint(columnNames = "date")}

)
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;
    private String type;
    private String moneyrecived;
    private String moneyPaid;
    private String gramsrecived;
    private String gramsPaid;
    private String employee;
    private String date;
    private String employee_in_charge;


    public Transactions() {
    }

    public Transactions(String name, String type, String moneyrecived, String moneyPaid, String gramsrecived, String gramsPaid, String employee, String date,String employee_in_charge) {
        Name = name;
        this.type = type;
        this.moneyrecived = moneyrecived;
        this.employee_in_charge=employee_in_charge;
        this.moneyPaid = moneyPaid;
        this.gramsrecived = gramsrecived;
        this.gramsPaid = gramsPaid;
        this.employee = employee;
        this.date = date;
    }

    public Transactions(int id, String name, String type, String moneyrecived, String moneyPaid, String gramsrecived, String gramsPaid, String employee, String date,String employee_in_charge) {
        this.id = id;
        this.employee_in_charge=employee_in_charge;
        Name = name;
        this.type = type;
        this.moneyrecived = moneyrecived;
        this.moneyPaid = moneyPaid;
        this.gramsrecived = gramsrecived;
        this.gramsPaid = gramsPaid;
        this.employee = employee;
        this.date = date;
    }

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoneyrecived() {
        return moneyrecived;
    }

    public void setMoneyrecived(String moneyrecived) {
        this.moneyrecived = moneyrecived;
    }

    public String getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(String moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public String getGramsrecived() {
        return gramsrecived;
    }

    public void setGramsrecived(String gramsrecived) {
        this.gramsrecived = gramsrecived;
    }

    public String getGramsPaid() {
        return gramsPaid;
    }

    public void setGramsPaid(String gramsPaid) {
        this.gramsPaid = gramsPaid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}