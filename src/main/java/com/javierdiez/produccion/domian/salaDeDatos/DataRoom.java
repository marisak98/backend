package com.javierdiez.produccion.domian.salaDeDatos;

import com.javierdiez.produccion.domian.team.Team;
import jakarta.persistence.*;

@Entity
@Table(name = "data_room")
public class DataRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_data_room;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
