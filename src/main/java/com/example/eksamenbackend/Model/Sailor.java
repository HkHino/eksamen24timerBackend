package com.example.eksamenbackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "Sailor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Sailor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int points;
    private int contestId;

}

