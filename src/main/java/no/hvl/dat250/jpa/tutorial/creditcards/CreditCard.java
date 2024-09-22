package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;

    @ManyToOne
    @JoinColumn(name= "bank_id")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "pincode_id")
    private Pincode pincode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CreditCard() {}

    public CreditCard(Integer number, Integer creditLimit, Integer balance, Bank bank, Pincode pincode, Customer customer) {
        this.number = number;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.bank = bank;
        this.pincode = pincode;
        this.customer = customer;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {
        return bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(id, that.id) && Objects.equals(number, that.number) && Objects.equals(creditLimit, that.creditLimit) && Objects.equals(balance, that.balance) && Objects.equals(bank, that.bank) && Objects.equals(pincode, that.pincode) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, creditLimit, balance, bank, pincode, customer);
    }
}
