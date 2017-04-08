/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.pojo.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author MumbaiZone
 */
@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @OneToOne
    private Individual supervisor;
    
    @OneToMany(mappedBy="parentTeam")
    private List<Individual> members = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Individual getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Individual supervisor) {
        this.supervisor = supervisor;
    }

    public List<Individual> getMembers() {
        return members;
    }

    public void setMembers(List<Individual> members) {
        this.members = members;
    }
    
    
    
}
