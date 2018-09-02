package com.treavit.backend.system.service;

import com.treavit.backend.system.entity.Role;
import com.treavit.backend.system.repository.RoleRepository;
import com.treavit.backend.system.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Component
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findOne(String id) {
        Optional<Role> role = roleRepository.findById(Long.valueOf(id));
        return role.orElseThrow(() -> new NotFoundException(format("Role with id: %s not found", id)));//TODO: Taras, is it ok?
    }
}
