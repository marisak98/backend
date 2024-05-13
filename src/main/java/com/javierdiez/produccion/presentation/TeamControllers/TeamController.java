package com.javierdiez.produccion.presentation.TeamControllers;

import com.javierdiez.produccion.application.teamService.TeamDto.CreateTeam;
import com.javierdiez.produccion.application.teamService.TeamService;
import com.javierdiez.produccion.domian.team.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/create")
    public ResponseEntity<Team> createTeam(@RequestBody CreateTeam teamDto){
        return null;
    }
}
