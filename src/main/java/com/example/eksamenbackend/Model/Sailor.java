package com.example.eksamenbackend.Model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Sailor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Sailor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int points;
    private int contestId;

}

