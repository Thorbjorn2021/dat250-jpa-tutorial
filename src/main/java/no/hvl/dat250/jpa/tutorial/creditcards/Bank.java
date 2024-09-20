package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Collection<CreditCard> creditCards;


    public Long getId() {
        return id;
    }

    public String getName() {
        // TODO: implement method!
        return null;
    }

    public Collection<CreditCard> getOwnedCards() {
        // TODO: implement method!
        return null;
    }
}
