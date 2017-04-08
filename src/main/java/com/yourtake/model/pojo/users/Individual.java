/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.pojo.users;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author MumbaiZone
 */
@Entity
public class Individual implements Serializable {
    
    @Id
    private String email;
    private String phone;
    private String name;
    private String password;
    private Integer power;
    private String myRole;
    private String organization;
    private Boolean access;
    @OneToOne(mappedBy="supervisor")
    private Team team;
   @ManyToOne
   private Team parentTeam;
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getMyRole() {
        return myRole;
    }

    public void setMyRole(String myRole) {
        this.myRole = myRole;
    }

   

    public Team getTeam() {
        return team;
    }


    public void setTeam(Team team) {
        this.team = team;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }

    public Team getParentTeam() {
        return parentTeam;
    }

    public void setParentTeam(Team parentTeam) {
        this.parentTeam = parentTeam;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    
    
}
