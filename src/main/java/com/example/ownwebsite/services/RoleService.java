package com.example.ownwebsite.services;

import com.example.ownwebsite.models.entities.Role;
import com.example.ownwebsite.models.entities.RoleNameEnum;

import java.util.List;

public interface RoleService {
    void inItRoles(List<Role> roles);
    Role returnRoleFromName(RoleNameEnum roleNameEnum);
    boolean isEmpty();
}
