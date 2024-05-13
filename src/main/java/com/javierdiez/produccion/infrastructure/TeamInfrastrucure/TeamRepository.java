package com.javierdiez.produccion.infrastructure.TeamInfrastrucure;

import com.javierdiez.produccion.domian.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName(String name_team);
}
