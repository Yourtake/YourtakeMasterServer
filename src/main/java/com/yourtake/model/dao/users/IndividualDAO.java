/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.users;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.users.Individual;
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
@Resource(name="individualDAO")
public class IndividualDAO implements GenericDAO<Individual>{
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Individual create(Individual object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Individual) session.get(Individual.class, object.getEmail());
                 
    }

    @Override
    public List<Individual> read(String criteia,Individual object) {
        List<Individual> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Individual) session.get(Individual.class, object.getEmail()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Individual update(Individual object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Individual) session.merge(object);
    }

    @Override
    public boolean delete(Individual object) {
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
