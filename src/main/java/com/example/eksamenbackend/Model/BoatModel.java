package com.example.eksamenbackend.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BoatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int points;
    //private Date dato;
    private boolean fod25;
    private boolean fod25_40;
    private boolean fod40;


    /**
     * A method, that checks if a boat method is valid. This is used when determining
     * if a model, provided by the frontend, contains the required fields, with decent values.
     * @return - true is the object is valid.
     */
    public boolean IsValid ()
    {
        return (points) >= 0 ; //todo spørg philip om en fornuftig løsning eller om bools bare er en dårlig ide
    }

    /**
     * This is a helper method, that checks if a string is either null or empty.
     *
     * */
    public boolean IsNullOrEmpty (String input)
    {
        return input == null || input.length() == 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
/*
    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }
*/
    public boolean isFod25() {
        return fod25;
    }

    public void setFod25(boolean fod25) {
        this.fod25 = fod25;
    }

    public boolean isFod25_40() {
        return fod25_40;
    }

    public void setFod25_40(boolean fod25_40) {
        this.fod25_40 = fod25_40;
    }

    public boolean isFod40() {
        return fod40;
    }

    public void setFod40(boolean fod40) {
        this.fod40 = fod40;
    }
}
