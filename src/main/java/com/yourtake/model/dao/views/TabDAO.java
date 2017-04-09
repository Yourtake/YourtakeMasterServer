/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.views;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.views.Tab;
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
@Resource(name="tabDao")
public class TabDAO implements GenericDAO<Tab>{
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Tab create(Tab object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Tab) session.get(Tab.class, object.getId());
                 
    }

    @Override
    public List<Tab> read(String criteia,Tab object) {
        List<Tab> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Tab) session.get(Tab.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Tab update(Tab object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Tab) session.merge(object);
    }

    @Override
    public boolean delete(Tab object) {
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
