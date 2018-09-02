package com.treavit.backend.system.controller;

import com.treavit.backend.system.dto.TeamDto;
import com.treavit.backend.system.entity.Team;
import com.treavit.backend.system.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/team")
public class TeamController {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping(value = "/all")
    public @ResponseBody List<Team> getAll() {
        return teamRepository.findAll();
    }

    @PostMapping(value = "/add")
    public @ResponseBody Team add(@RequestBody TeamDto teamDto) {
         return teamRepository.save(dtoToEntity(teamDto));
    }

    private Team dtoToEntity(TeamDto teamDto) {
        Team team = new Team();
        team.setName(teamDto.getName());
        return team;
    }

}
