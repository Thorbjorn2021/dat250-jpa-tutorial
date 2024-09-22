package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "pincode_id")
    private Pincode pincode;

    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getCreditLimit() {
        // TODO: implement method!
        return null;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {
        // TODO: implement method!
        return null;
    }
}
