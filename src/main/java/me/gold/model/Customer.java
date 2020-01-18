package me.gold.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.security.PrivateKey;

@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(
        uniqueConstraints=
                {@UniqueConstraint(columnNames = {"name", "telephone"}), @UniqueConstraint(columnNames = {"name", "another_telephone"}),@UniqueConstraint(columnNames = {"name", "Address"}),@UniqueConstraint(columnNames = {"telephone"})}

)
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String telephone;
    private String another_telephone;
    private String employee_in_charge;
    public Customer() {
    }

    public String getEmployee_in_charge() {
        return employee_in_charge;
    }

    public void setEmployee_in_charge(String employee_in_charge) {
        this.employee_in_charge = employee_in_charge;
    }

    public Customer(int id, String name, String telephone, String another_telephone, String address, String employee_in_charge) {
        this.id = id;
        this.name = name;
this.employee_in_charge=employee_in_charge;
        this.telephone = telephone;
        this.another_telephone = another_telephone;
        Address = address;
    }

    private String Address;

    public Customer(String name, String telephone, String another_telephone, String address,String employee_in_charge) {
        this.name = name;
        this.employee_in_charge=employee_in_charge;
        this.telephone = telephone;
        this.another_telephone = another_telephone;
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

    public String getAnother_telephone() {
        return another_telephone;
    }

    public void setAnother_telephone(String another_telephone) {
        this.another_telephone = another_telephone;
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
                ", another_telephone='" + another_telephone + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
