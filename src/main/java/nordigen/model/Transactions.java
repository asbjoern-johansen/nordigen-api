package nordigen.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import nordigen.api.rest.TransactionsDeserializer;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = TransactionsDeserializer.class)
public class Transactions {

    private List<Transaction> booked = new ArrayList<>();
    private List<Transaction> pending  = new ArrayList<>();;

    public List<Transaction> getBooked() {
        return booked;
    }

    public void setBooked(List<Transaction> booked) {
        this.booked = booked;
    }

    public List<Transaction> getPending() {
        return pending;
    }

    public void setPending(List<Transaction> pending) {
        this.pending = pending;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "booked=" + booked +
                ", pending=" + pending +
                '}';
    }
}
