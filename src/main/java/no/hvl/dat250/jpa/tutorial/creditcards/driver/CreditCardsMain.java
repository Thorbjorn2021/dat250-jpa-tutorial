package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Address address = new Address("Inndalsveien", 28);
    Customer customer = new Customer("Max Mustermann");
    address.getOwners().add(customer);
    customer.getAddresses().add(address);

    Bank bank = new Bank("Pengebank");

    Pincode pincode = new Pincode("123", 1);

    CreditCard creditCard1 = new CreditCard(12345, -10000, -5000, bank, pincode, customer);
    CreditCard creditCard2 = new CreditCard(123, 2000, 1, bank, pincode, customer);

    bank.getOwnedCards().add(creditCard1);
    bank.getOwnedCards().add(creditCard2);

    customer.getCreditCards().add(creditCard1);
    customer.getCreditCards().add(creditCard2);

    em.persist(customer);
    em.persist(bank);
    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(address);
    em.persist(pincode);

  }
}
