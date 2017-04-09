/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.views;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.views.FormInput;
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
@Resource(name="formInputDao")
public class FormInputDAO implements GenericDAO<FormInput>{
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public FormInput create(FormInput object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (FormInput) session.get(FormInput.class, object.getId());
                 
    }

    @Override
    public List<FormInput> read(String criteia,FormInput object) {
        List<FormInput> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((FormInput) session.get(FormInput.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public FormInput update(FormInput object) {
       Session session = getSessionFactory().getCurrentSession();
        return (FormInput) session.merge(object);
    }

    @Override
    public boolean delete(FormInput object) {
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
