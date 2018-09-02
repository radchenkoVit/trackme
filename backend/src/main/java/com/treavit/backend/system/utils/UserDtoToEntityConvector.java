package com.treavit.backend.system.utils;

import com.treavit.backend.system.dto.UserDto;
import com.treavit.backend.system.entity.Image;
import com.treavit.backend.system.entity.Role;
import com.treavit.backend.system.entity.Team;
import com.treavit.backend.system.entity.User;
import com.treavit.backend.system.repository.ImageRepository;
import com.treavit.backend.system.service.RoleService;
import com.treavit.backend.system.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

@Component
public class UserDtoToEntityConvector {

    private final RoleService roleService;
    private final TeamService teamService;
    private final ImageRepository imageRepository;

    @Autowired
    public UserDtoToEntityConvector(RoleService roleService, TeamService teamService, ImageRepository imageRepository) {
        this.roleService = roleService;
        this.teamService = teamService;
        this.imageRepository = imageRepository;
    }

    public User convertToEntity(UserDto userDto) throws IOException {
        User user = new User();
        user.setFirstName(userDto.getLastName());
        user.setLastName(userDto.getLastName());
        user.setDaysUsed(0);
        user.setDaysLeft(0);

        Team team = teamService.findOne(userDto.getTeamId());
        user.getTeams().add(team);
        Role role = roleService.findOne(userDto.getRoleId());
        user.getRoles().add(role);
        Image image = new Image();
        image.setImage(getDefaultImage());
        user.setImage(image);

        return user;
    }

    private byte[] getDefaultImage() throws IOException {
        URL url = this.getClass().getClassLoader().getResource("image.png");
        File file = null;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            //TODO: log message
        }

        return Files.readAllBytes(file.toPath());
    }
}
