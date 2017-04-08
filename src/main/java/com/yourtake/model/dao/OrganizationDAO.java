/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao;

import com.yourtake.model.pojo.setup.Organization;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MumbaiZone
 */
@Repository
@Resource(name="organizationDAO")
public class OrganizationDAO implements GenericDAO<Organization> {
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Organization create(Organization object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Organization) session.get(Organization.class, object.getId());
                 
    }

    @Override
    public List<Organization> read(String criteia,Organization object) {
        List<Organization> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Organization) session.get(Organization.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Organization update(Organization object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Organization) session.merge(object);
    }

    @Override
    public boolean delete(Organization object) {
        return false;
    }

    
    
@Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

@Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
