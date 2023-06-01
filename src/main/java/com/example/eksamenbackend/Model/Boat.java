package com.example.eksamenbackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "boats")
public class Boat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //todo this should be done as an enum, as this would be significantly better
    private String type;

    /**
     * A method, that checks if a boat method is valid. This is used when determining
     * if a model, provided by the frontend, contains the required fields, with decent values.
     * @return - true is the object is valid.
     */
    public boolean IsValid ()
    {

        return (type.equals("25fod") || type.equals("25_40fod")||type.equals("40fod"));
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
