package com.treavit.backend.system.controller;

import com.treavit.backend.system.entity.Role;
import com.treavit.backend.system.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping(path = "/role/all")
    public @ResponseBody List<Role> getAll() {
        return roleRepository.findAll();
    }
}
