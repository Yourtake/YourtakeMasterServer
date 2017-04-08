/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.model.dao.setup;

import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.setup.Branch;
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
@Resource(name="branchDAO")
public class BranchDAO implements GenericDAO<Branch> {
@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Branch create(Branch object) {
           Session  session = getSessionFactory().getCurrentSession();
            session.save(object);
            return (Branch) session.get(Branch.class, object.getId());
                 
    }

    @Override
    public List<Branch> read(String criteia,Branch object) {
        List<Branch> list= new ArrayList<>();
        switch(criteia){
            case "id":
                    Session session = getSessionFactory().getCurrentSession();
                     list.add((Branch) session.get(Branch.class, object.getId()));
                break;
            default:
                break;
        }
        
        return list;
    }

    @Override
    public Branch update(Branch object) {
       Session session = getSessionFactory().getCurrentSession();
        return (Branch) session.merge(object);
    }

    @Override
    public boolean delete(Branch object) {
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
