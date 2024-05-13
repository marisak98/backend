package com.javierdiez.produccion.domian.emails;

import com.javierdiez.produccion.domian.team.Team;
import jakarta.persistence.*;

@Entity
@Table(name = "email")
public class Emails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_email;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
