package com.javierdiez.produccion.application.teamService;

import com.javierdiez.produccion.application.Authentication.AuthenticationService;
import com.javierdiez.produccion.application.teamService.TeamDto.CreateTeam;
import com.javierdiez.produccion.domian.team.Team;
import com.javierdiez.produccion.domian.usuarioDomain.Usuario;
import com.javierdiez.produccion.infrastructure.TeamInfrastrucure.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final AuthenticationService authenticationService;

    @Autowired
    public TeamService(TeamRepository teamRepository, AuthenticationService authenticationService) {
        this.teamRepository = teamRepository;
        this.authenticationService = authenticationService;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamByName(){
        return teamRepository.findByName("name_team");
    }

    public Team saveTeam(CreateTeam createTeam){
        Usuario currentUser = authenticationService.getCurrentUser();
        Team team = new Team().setName(createTeam.getName_team());
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id){
        teamRepository.deleteById(id);
    }
}
