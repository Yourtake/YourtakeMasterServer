/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao;

import com.yourtake.model.pojo.users.Team;
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
@Resource(name="teamDAO")
public class TeamDAO implements GenericDAO<Team>{
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Team create(Team object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Team) session.get(Team.class, object.getId());
                 
    }

    @Override
    public List<Team> read(String criteia,Team object) {
        List<Team> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Team) session.get(Team.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Team update(Team object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Team) session.merge(object);
    }

    @Override
    public boolean delete(Team object) {
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
