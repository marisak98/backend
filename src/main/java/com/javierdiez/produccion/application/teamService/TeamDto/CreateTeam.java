package com.javierdiez.produccion.application.teamService.TeamDto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter @Getter
@Accessors(chain = true)
public class CreateTeam {
    private String name_team;
}
