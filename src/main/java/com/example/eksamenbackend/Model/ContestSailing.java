package com.example.eksamenbackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ContestSailing")
public class ContestSailing
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contestId;
    private int boatId;
    private int placement;
}
