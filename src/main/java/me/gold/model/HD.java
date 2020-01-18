package me.gold.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = {"name","country"})})
public class HD {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;
    private String amount;
    public HD() {
    }

    public HD(String name, String country, String amount) {
        this.name = name;
             this.amount = amount;
             this.country=country;
    }

    public HD(int id, String name,String country,  String amount) {
        this.id = id;
        this.name = name;
        this.country=country;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
