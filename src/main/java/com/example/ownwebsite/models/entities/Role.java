package com.example.ownwebsite.models.entities;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BaseEntity{

    private RoleNameEnum roleNameEnum;

    public Role() {
    }

    public Role(RoleNameEnum roleNameEnum) {
        this.roleNameEnum = roleNameEnum;
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getRoleNameEnum() {
        return roleNameEnum;
    }

    public Role setRoleNameEnum(RoleNameEnum roleNameEnum) {
        this.roleNameEnum = roleNameEnum;
        return this;
    }
}
