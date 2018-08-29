package com.treavit.backend.system.controller;

import com.treavit.backend.system.entity.Team;
import com.treavit.backend.system.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeamController {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping(path = "/team/all")
    public @ResponseBody List<Team> getAll() {
        return teamRepository.findAll();
    }

}