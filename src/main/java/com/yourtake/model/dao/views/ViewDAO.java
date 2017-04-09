/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.views;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.views.View;
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
@Resource(name="viewDao")
public class ViewDAO implements GenericDAO<View>{
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public View create(View object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (View) session.get(View.class, object.getId());
                 
    }

    @Override
    public List<View> read(String criteia,View object) {
        List<View> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((View) session.get(View.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public View update(View object) {
       Session session = getSessionFactory().getCurrentSession();
        return (View) session.merge(object);
    }

    @Override
    public boolean delete(View object) {
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
