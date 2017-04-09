/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.views;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.views.Header;
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
@Resource(name="headerDao")
public class HeaderDAO implements GenericDAO<Header>{
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Header create(Header object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Header) session.get(Header.class, object.getId());
                 
    }

    @Override
    public List<Header> read(String criteia,Header object) {
        List<Header> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Header) session.get(Header.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Header update(Header object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Header) session.merge(object);
    }

    @Override
    public boolean delete(Header object) {
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
