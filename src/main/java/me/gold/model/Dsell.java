package me.gold.model;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints=
                {@UniqueConstraint(columnNames = "date")}

)
public class Dsell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  Gram_Type;
    private String Details;
    private String weight;
    private String Payment;
    private String gram_cash_price;
    private String gram_card_price;
    private String No_Of_grams_Paid_cash;
    private String No_Of_grams_Paid_card ;
    private  String date;
    private String employee_in_charge;

    public Dsell() {
    }

    public Dsell(int id, String gram_Type, String details, String weight, String payment, String gram_cash_price, String gram_card_price, String no_Of_grams_Paid_cash, String no_Of_grams_Paid_card,String date,String employee_in_charge) {
        this.id = id;
        this.Gram_Type = gram_Type;
        this.Details = details;
        this.weight = weight;
        this.Payment = payment;
        this.gram_cash_price = gram_cash_price;
        this.gram_card_price = gram_card_price;
        this.No_Of_grams_Paid_cash = no_Of_grams_Paid_cash;
        this.No_Of_grams_Paid_card = no_Of_grams_Paid_card;
        this.date=date;
        this.employee_in_charge=employee_in_charge;
    }

    public Dsell(String gram_Type, String details, String weight, String payment, String gram_cash_price, String gram_card_price, String no_Of_grams_Paid_cash, String no_Of_grams_Paid_card,String date,String employee_in_charge) {
        this.Gram_Type = gram_Type;
        this.employee_in_charge=employee_in_charge;
        this.Details = details;
        this.weight = weight;
        this.Payment = payment;
        this.gram_cash_price = gram_cash_price;
        this.gram_card_price = gram_card_price;
        this.No_Of_grams_Paid_cash = no_Of_grams_Paid_cash;
        this.No_Of_grams_Paid_card = no_Of_grams_Paid_card;
        this.date=date;
    }

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGram_Type() {
        return Gram_Type;
    }

    public void setGram_Type(String gram_Type) {
        Gram_Type = gram_Type;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String payment) {
        Payment = payment;
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

    public String getNo_Of_grams_Paid_cash() {
        return No_Of_grams_Paid_cash;
    }

    public void setNo_Of_grams_Paid_cash(String no_Of_grams_Paid_cash) {
        No_Of_grams_Paid_cash = no_Of_grams_Paid_cash;
    }

    public String getNo_Of_grams_Paid_card() {
        return No_Of_grams_Paid_card;
    }

    public void setNo_Of_grams_Paid_card(String no_Of_grams_Paid_card) {
        No_Of_grams_Paid_card = no_Of_grams_Paid_card;
    }
}
