package com.example.ownwebsite.repositories;

import com.example.ownwebsite.models.entities.Role;
import com.example.ownwebsite.models.entities.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByRoleNameEnum(RoleNameEnum roleNameEnum);

}
