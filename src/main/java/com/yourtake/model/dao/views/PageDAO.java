/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.views;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.views.Page;
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
@Resource(name="pageDao")
public class PageDAO implements GenericDAO<Page>{
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Page create(Page object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Page) session.get(Page.class, object.getId());
                 
    }

    @Override
    public List<Page> read(String criteia,Page object) {
        List<Page> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Page) session.get(Page.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Page update(Page object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Page) session.merge(object);
    }

    @Override
    public boolean delete(Page object) {
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
