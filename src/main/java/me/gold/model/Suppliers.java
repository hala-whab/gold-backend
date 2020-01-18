package me.gold.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
//
//@Entity
//@Table(
//        uniqueConstraints=
//                {@UniqueConstraint(columnNames = {"name", "telephone"}), @UniqueConstraint(columnNames = {"name", "another_telephone"}),@UniqueConstraint(columnNames = {"name", "Address"}),@UniqueConstraint(columnNames = {"telephone"})}
//
//)
public class Suppliers {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String telephone;

    private String employee_in_charge;
    public Suppliers() {
    }

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }

    public Suppliers(int id, String name, String telephone,  String address, String employee_in_charge) {
        this.id = id;
        this.name = name;
this.employee_in_charge=employee_in_charge;
        this.telephone = telephone;

        Address = address;
    }

    private String Address;

    public Suppliers(String name, String telephone,  String address, String employee_in_charge) {
        this.name = name;
        this.employee_in_charge=employee_in_charge;
        this.telephone = telephone;
        Address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
