package com.alish.blog_spring.services.impl;

import com.alish.blog_spring.models.Role;
import com.alish.blog_spring.repositories.RoleRepository;
import com.alish.blog_spring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }
}
