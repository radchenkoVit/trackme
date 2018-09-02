package com.treavit.backend.system.service;

import com.treavit.backend.system.entity.Team;
import com.treavit.backend.system.repository.TeamRepository;
import com.treavit.backend.system.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Component
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findOne(String id) {
        Optional<Team> team = teamRepository.findById(Long.valueOf(id));
        return team.orElseThrow(() -> new NotFoundException(format("Team with id: %s not found", id)));//TODO: Taras, is it ok?
    }
}
