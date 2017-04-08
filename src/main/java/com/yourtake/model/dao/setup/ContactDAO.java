/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.setup;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.setup.Contact;
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
@Resource(name="contactDAO")
public class ContactDAO implements GenericDAO<Contact> {
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Contact create(Contact object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Contact) session.get(Contact.class, object.getId());
                 
    }

    @Override
    public List<Contact> read(String criteia,Contact object) {
        List<Contact> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Contact) session.get(Contact.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Contact update(Contact object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Contact) session.merge(object);
    }

    @Override
    public boolean delete(Contact object) {
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
