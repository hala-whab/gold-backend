package me.gold.model;

import javax.persistence.*;
import java.util.Date;

@Entity

public class save {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Total_Grams;
    private String Bah_Grams;
    private String Kwe_Grams;
    private String Sud_Grams;
    private String Used_Grams;
    private String Tur_Grams;
    private String Cash;
    private String Bank;
    private String Money;
    private String employee_in_charge;

    public save() {
    }

    public save(int id, String total_Grams, String bah_Grams, String kwe_Grams, String sud_Grams, String used_Grams, String tur_Grams, String cash, String bank, String money,String employee_in_charge) {
        this.id = id;
        Total_Grams = total_Grams;
        Bah_Grams = bah_Grams;
        Kwe_Grams = kwe_Grams;
        Sud_Grams = sud_Grams;
        this.employee_in_charge=employee_in_charge;
        Used_Grams = used_Grams;
        Tur_Grams = tur_Grams;
        Cash = cash;
        Bank = bank;
        Money = money;
    }

    public save(String total_Grams, String bah_Grams, String kwe_Grams, String sud_Grams, String used_Grams, String tur_Grams, String cash, String bank, String money,String employee_in_charge) {
        Total_Grams = total_Grams;
        Bah_Grams = bah_Grams;
        this.employee_in_charge=employee_in_charge;
        Kwe_Grams = kwe_Grams;
        Sud_Grams = sud_Grams;
        Used_Grams = used_Grams;
        Tur_Grams = tur_Grams;
        Cash = cash;
        Bank = bank;
        Money = money;
    }

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTotal_Grams() {
        return Total_Grams;
    }

    public void setTotal_Grams(String total_Grams) {
        Total_Grams = total_Grams;
    }

    public String getBah_Grams() {
        return Bah_Grams;
    }

    public void setBah_Grams(String bah_Grams) {
        Bah_Grams = bah_Grams;
    }

    public String getKwe_Grams() {
        return Kwe_Grams;
    }

    public void setKwe_Grams(String kwe_Grams) {
        Kwe_Grams = kwe_Grams;
    }

    public String getSud_Grams() {
        return Sud_Grams;
    }

    public void setSud_Grams(String sud_Grams) {
        Sud_Grams = sud_Grams;
    }

    public String getUsed_Grams() {
        return Used_Grams;
    }

    public void setUsed_Grams(String used_Grams) {
        Used_Grams = used_Grams;
    }

    public String getTur_Grams() {
        return Tur_Grams;
    }

    public void setTur_Grams(String tur_Grams) {
        Tur_Grams = tur_Grams;
    }

    public String getCash() {
        return Cash;
    }

    public void setCash(String cash) {
        Cash = cash;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }
}