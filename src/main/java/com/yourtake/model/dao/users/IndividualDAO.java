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
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MumbaiZone
 */
@Repository
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
    
    
     public Individual createInit(Individual object) {
         Individual admin = (Individual) object;
         
         Session session=null;
        try{
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(admin);
            admin = (Individual) session.get(Individual.class, admin.getEmail());
            session.getTransaction().commit();
        }
        catch(Exception e){
            session.getTransaction().rollback();
            System.out.println("Error in building Individual and its properties at IndividualDAO "+e);
            e.printStackTrace();
            admin=null;
        }
        finally{
            if(session.isOpen()){
                
            }
            session=null;
        }
        return  admin;
    }

}
