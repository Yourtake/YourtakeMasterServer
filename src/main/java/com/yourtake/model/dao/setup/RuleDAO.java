/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.setup;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.setup.Rule;
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
@Resource(name="ruleDAO")
public class RuleDAO implements GenericDAO<Rule> {
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Rule create(Rule object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Rule) session.get(Rule.class, object.getId());
                 
    }

    @Override
    public List<Rule> read(String criteia,Rule object) {
        List<Rule> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Rule) session.get(Rule.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Rule update(Rule object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Rule) session.merge(object);
    }

    @Override
    public boolean delete(Rule object) {
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
