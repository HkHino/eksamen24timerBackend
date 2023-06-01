package com.example.eksamenbackend.Model;

import jakarta.persistence.*;

@Entity
public class Sailor
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    public boolean IsValid () {
        return true;
    }



}

