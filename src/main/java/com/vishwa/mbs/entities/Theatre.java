package com.vishwa.mbs.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Theatre {

    @Id
    @GeneratedValue
    private int theatreId;

    @Column(length = 20, nullable = false, unique = true)
    private String theatreName;

    @Column(nullable = false)
    private float ticketPrice = 150.00f;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @JsonManagedReference
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Theatre{" + "theatreId=" + theatreId + ", theatreName='" + theatreName + '\'' + ", ticketPrice="
                + ticketPrice + '}';
    }
}
