package com.example.ownwebsite.services;

import com.example.ownwebsite.models.entities.Role;
import com.example.ownwebsite.models.entities.RoleNameEnum;
import com.example.ownwebsite.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void inItRoles(List<Role> roles) {
        this.roleRepository.saveAll(roles);
    }

    @Override
    public Role returnRoleFromName(RoleNameEnum roleNameEnum) {
        return this.roleRepository.findRoleByRoleNameEnum(roleNameEnum);
    }

    @Override
    public boolean isEmpty() {
        return this.roleRepository.count()==0;
    }


}
