/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.pojo.setup;

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
public class Organization implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private String url;
    private Integer live_count;
    private Integer count;
    private String barcodeImageUrl;
    private String metadata;
    @OneToOne(mappedBy = "masterRelation")
    private Branch master;
    @OneToMany(mappedBy = "branchRelation")
    private List<Branch> branches = new ArrayList<>();
    @OneToMany(mappedBy = "organization")
    private List<Rule> rules = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLive_count() {
        return live_count;
    }

    public void setLive_count(Integer live_count) {
        this.live_count = live_count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBarcodeImageUrl() {
        return barcodeImageUrl;
    }

    public void setBarcodeImageUrl(String barcodeImageUrl) {
        this.barcodeImageUrl = barcodeImageUrl;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Branch getMaster() {
        return master;
    }

    public void setMaster(Branch master) {
        this.master = master;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
        
        



}
