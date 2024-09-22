package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private Integer count;

    public Pincode() {}

    public Pincode(String pincode, Integer count) {
        this.pincode = pincode;
        this.count = count;
    }

    public Long getId() {
        return id;
    }
    public String getCode() {
        return pincode;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pincode pincode1 = (Pincode) o;
        return Objects.equals(id, pincode1.id) && Objects.equals(pincode, pincode1.pincode) && Objects.equals(count, pincode1.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pincode, count);
    }
}
