package com.treavit.backend.system.controller;

import com.treavit.backend.system.dto.UserDto;
import com.treavit.backend.system.entity.User;
import com.treavit.backend.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public @ResponseBody List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping(value = "/add")
    public @ResponseBody User addUser(@RequestBody UserDto userDto) throws IOException {
        return userService.save(userDto);
    }
}
