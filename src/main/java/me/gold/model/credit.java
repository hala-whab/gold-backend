package me.gold.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String beneficial_id;
    private String beneficial_name;
    private String benefit_amount;
    private String credit_type;
    private String benfit_date;
    private String employee_in_charge;

    public credit() {
    }

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }

    public String getBeneficial_id() {
        return beneficial_id;
    }

    public void setBeneficial_id(String beneficial_id) {
        this.beneficial_id = beneficial_id;
    }

    public String getBeneficial_name() {
        return beneficial_name;
    }

    public void setBeneficial_name(String beneficial_name) {
        this.beneficial_name = beneficial_name;
    }

    public String getBenefit_amount() {
        return benefit_amount;
    }

    public void setBenefit_amount(String benefit_amount) {
        this.benefit_amount = benefit_amount;
    }

    public String getCredit_type() {
        return credit_type;
    }

    public void setCredit_type(String credit_type) {
        this.credit_type = credit_type;
    }

    public String getBenfit_date() {
        return benfit_date;
    }

    public void setBenfit_date(String benfit_date) {
        this.benfit_date = benfit_date;
    }

    public credit(String beneficial_id, String beneficial_name, String benefit_amount, String credit_type, String benfit_date,String employee_in_charge) {
        this.beneficial_id = beneficial_id;
        this.beneficial_name = beneficial_name;
        this.benefit_amount = benefit_amount;
        this.credit_type = credit_type;
        this.benfit_date = benfit_date;
        this.employee_in_charge=employee_in_charge;
    }

    public credit(int id, String beneficial_id, String beneficial_name, String benefit_amount, String credit_type, String benfit_date,String employee_in_charge) {
        this.id = id;
        this.beneficial_id = beneficial_id;
        this.employee_in_charge=employee_in_charge;
        this.beneficial_name = beneficial_name;
        this.benefit_amount = benefit_amount;
        this.credit_type = credit_type;
        this.benfit_date = benfit_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}