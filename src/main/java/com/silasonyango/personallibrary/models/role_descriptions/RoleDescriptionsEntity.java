package com.silasonyango.personallibrary.models.role_descriptions;

import javax.persistence.*;
@javax.persistence.Entity
@Table(name = "roles")
public class RoleDescriptionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RoleId")
    private int roleId;

    @Column(name = "RoleDescription")
    private String roleDescription;

    @Column(name = "RoleCode")
    private String roleCode;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
