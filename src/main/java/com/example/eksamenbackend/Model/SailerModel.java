package com.example.eksamenbackend.Model;

import jakarta.persistence.*;

@Entity
public class SailerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private boolean participates;
    //private Date dato;
    private boolean fod25;
    private boolean fod25_40;
    private boolean fod40;


    public boolean isParticipates() {
        return participates;
    }

    public void setParticipates(boolean participates) {
        this.participates = participates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

