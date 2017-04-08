/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.views;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.views.Footer;
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
@Resource(name="footerDAO")
public class FooterDAO implements GenericDAO<Footer>{
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Footer create(Footer object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Footer) session.get(Footer.class, object.getId());
                 
    }

    @Override
    public List<Footer> read(String criteia,Footer object) {
        List<Footer> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Footer) session.get(Footer.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Footer update(Footer object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Footer) session.merge(object);
    }

    @Override
    public boolean delete(Footer object) {
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
